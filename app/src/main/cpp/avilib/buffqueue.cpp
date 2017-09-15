//
// Created by leon on 2017/9/5.
//
extern "C" {
#include "wavlib.h"
}

#include <SLES/OpenSLES.h>
#include <SLES/OpenSLES_Android.h>

#include "buffqueue.h"
#include <android/log.h>
#define LOGI(FORMAT, ...) __android_log_print(ANDROID_LOG_INFO,"TAG",FORMAT,##__VA_ARGS__);
#define LOGE(FORMAT, ...) __android_log_print(ANDROID_LOG_ERROR,"TAG",FORMAT,##__VA_ARGS__);


#define ARRAY_LEN(a) (sizeof(a) / sizeof(a[0]))


void create_buffer_queue_audio_player(
        WAV wav, SLEngineItf engine, SLObjectItf output_mix_obj, SLObjectItf &audio_player_obj) {
    //Android针对数据源的简单换中区队列定位器
    SLDataLocator_AndroidSimpleBufferQueue data_source_locator = {
            SL_DATALOCATOR_ANDROIDSIMPLEBUFFERQUEUE,//定位器类型
            1                                       //缓冲数据
    };

    //PCM数据源格式
    SLDataFormat_PCM data_source_format = {
            SL_DATAFORMAT_PCM,        // 格式类型
            wav_get_channels(wav),    // 通道数
            wav_get_rate(wav) * 1000, // 毫赫兹/秒的样本数
            wav_get_bits(wav),        // 每个样本的位数
            wav_get_bits(wav),        // 容器大小
            SL_SPEAKER_FRONT_CENTER,  // 通道屏蔽
            SL_BYTEORDER_LITTLEENDIAN // 字节顺序
    };

    // 数据源是含有PCM格式的简单缓冲区队列
    SLDataSource data_source = {
            &data_source_locator, // 数据定位器
            &data_source_format   // 数据格式
    };

    // 针对数据接收器的输出混合定位器
    SLDataLocator_OutputMix data_sink_locator = {
            SL_DATALOCATOR_OUTPUTMIX, // 定位器类型
            output_mix_obj           // 输出混合
    };


    // 数据定位器是一个输出混合
    SLDataSink data_sink = {
            &data_sink_locator, // 定位器
            0                 // 格式
    };

    // 需要的接口
    SLInterfaceID interface_ids[] = {
            SL_IID_BUFFERQUEUE
    };

    // 需要的接口，如果所需要的接口不要用，请求将失败
    SLboolean required_interfaces[] = {
            SL_BOOLEAN_TRUE // for SL_IID_BUFFERQUEUE
    };

    // 创建音频播放器对象
    SLresult result = (*engine)->CreateAudioPlayer(
            engine,
            &audio_player_obj,
            &data_source,
            &data_sink,
            ARRAY_LEN(interface_ids),
            interface_ids,
            required_interfaces);
}