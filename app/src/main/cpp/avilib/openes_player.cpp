//
// Created by leon on 2017/9/5.
//

#include "openes_player.h";
#include "buffqueue.h"
#include <android/log.h>

#define LOGI(FORMAT, ...) __android_log_print(ANDROID_LOG_INFO,"TAG",FORMAT,##__VA_ARGS__);
#define LOGE(FORMAT, ...) __android_log_print(ANDROID_LOG_ERROR,"TAG",FORMAT,##__VA_ARGS__);

extern "C" {
#include "wavlib.h"
}

#include <SLES/OpenSLES.h>
#include <SLES/OpenSLES_Android.h>

#include <iostream>
#include <fstream>

using namespace std;

#define ARRAY_LEN(a) (sizeof(a) / sizeof(a[0]))

WAV wav; //wav文件指针
SLObjectItf engine_object; //引擎对象
SLEngineItf engine_interface; //引擎接口
SLObjectItf output_mix_object; //混音器
SLObjectItf audio_player_object; //播放器对象
SLAndroidSimpleBufferQueueItf andio_player_buffer_queue;    //缓冲器队列接口
SLPlayItf audio_play_interface;    //播放接口
unsigned char *buffer; //缓冲区
size_t buffer_size;       //缓冲区大小



//上下文
struct PlayerContext {
    WAV wav;
    unsigned char *buffer;
    size_t buffer_size;

    PlayerContext(WAV wav,
                  unsigned char *buffer,
                  size_t bufferSize) {
        this->wav = wav;
        this->buffer = buffer;
        this->buffer_size = bufferSize;
    }
};

/**
 * 打开文件
 * @param env
 * @param jpath
 * @return
 */
WAV open_wave_file(JNIEnv *env, jstring jpath) {
    const char *c_path = env->GetStringUTFChars(jpath, JNI_FALSE);
    WAVError err;
    WAV wav = wav_open(c_path, WAV_READ, &err);
    LOGI("%d", wav_get_bitrate(wav));
    if (wav == 0) {
        LOGE("%s", wav_strerror(err));
    }
    env->ReleaseStringUTFChars(jpath, c_path);
    return wav;
}

/**
 * 关闭文件
 * @param wav
 */
void close_wave_file(WAV wav) {
    wav_close(wav);
}

/**
 * 实例化对象
 * @param pItf_
 */
void realize_object(SLObjectItf engine_object) {
    //阻塞式
    (*engine_object)->Realize(engine_object, SL_BOOLEAN_FALSE);
}


/**
 * 回调函数
 * @param andioPlayerBufferQueue
 * @param context
 */
void player_callback(SLAndroidSimpleBufferQueueItf andioPlayerBufferQueue, void *context) {
    PlayerContext *ctx = (PlayerContext *) context;
    //读取数据
    ssize_t read_size = wav_read_data(
            ctx->wav,
            ctx->buffer,
            ctx->buffer_size
    );
    if (0 < read_size) {
        (*andioPlayerBufferQueue)->Enqueue(andioPlayerBufferQueue, ctx->buffer, read_size);
    } else {
        //destroy context
        close_wave_file(ctx->wav); //关闭文件
        delete ctx->buffer; //释放缓存
    }
}

JNIEXPORT void JNICALL Java_leon_training_ndk_opensles_OpenESPlayer_play
        (JNIEnv *env, jclass cls, jstring jpath) {
    LOGE("play()");
    const char *c_path = env->GetStringUTFChars(jpath, JNI_FALSE);
    //0.检查文件是否存在
    fstream file;
    file.open(c_path, ios::in);
    if (!file) {
        cout << " 文件不存在" << c_path << endl;
        return;
    }

    //1.打开文件
    WAV wav = open_wave_file(env, jpath);

    //2.创建OpenSL ES引擎
    SLEngineOption options[] = {
            {(SLuint32) SL_ENGINEOPTION_THREADSAFE, (SLuint32) SL_BOOLEAN_TRUE}
    };
    slCreateEngine(&engine_object, ARRAY_LEN(engine_object), options, 0, 0, 0); //没有接口
    //实例化对象
    //对象创建后，处于未实例化状态,对象虽然存在但未分配任何资源，使用前先实例化（使用完销毁）
    realize_object(engine_object);

    //3.获取引擎接口
    (*engine_object)->GetInterface(
            engine_object,
            SL_IID_ENGINE,
            &engine_interface
    );

    //4.创建输出混音器
    (*engine_interface)->CreateOutputMix(
            engine_interface,
            &output_mix_object,
            0,
            0,
            0
    );
    //实例化混音器
    realize_object(output_mix_object);

    //5.创建缓冲区保存读取到的音频数据
    //缓冲区的大小
    buffer_size = wav_get_channels(wav) * wav_get_rate(wav);
    buffer = new unsigned char[buffer_size];

    //6.创建带有缓冲区队列的音频播放器
    create_buffer_queue_audio_player(
            wav,
            engine_interface,
            output_mix_object,
            audio_player_object
    );
    realize_object(audio_player_object);

    //7.获得缓冲区队列接口Buffer Queue Interface
    //通过缓冲区队列接口对缓冲区进行排序播放
    (*audio_player_object)->GetInterface(
            audio_player_object,
            SL_IID_BUFFERQUEUE,
            &andio_player_buffer_queue
    );

    //8.注册音频播放器回调函数
    //当播放器完成对前一个缓冲区队列的播放时，回调函数会被调用，然后我们又继续读取音频数据，直到结束
    //上下文，包裹参数方便再回调函数中使用
    PlayerContext *ctx = new PlayerContext(wav, buffer, buffer_size);
    (*andio_player_buffer_queue)->RegisterCallback(
            andio_player_buffer_queue,
            player_callback,
            ctx);

    //9.获取Play Interface通过对SetPlayState函数来启动播放音乐
    //一旦播放器被设置为播放状态，该音频播放器开始等待缓冲区排队就绪
    (*audio_player_object)->GetInterface(audio_player_object, SL_IID_PLAY, &audio_play_interface);
    //设置播放状态
    (*audio_play_interface)->SetPlayState(audio_play_interface, SL_PLAYSTATE_PLAYING);

    //10.开始，让第一个缓冲区入队
    player_callback(andio_player_buffer_queue, ctx);

    //关闭文件
    //CloseWaveFile(wav);
}


JNIEXPORT void JNICALL Java_leon_training_ndk_opensles_OpenESPlayer_stop
        (JNIEnv *env, jclass cls) {
    LOGE("stop()");
}