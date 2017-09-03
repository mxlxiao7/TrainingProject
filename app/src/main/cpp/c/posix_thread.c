//
// Created by leon on 2017/9/3.
//
#include <jni.h>
#include <android/log.h>
#include <stdio.h>
#include <pthread.h>
#include <unistd.h>

#include "posix_thread.h"
#include "jnilog.h"

#define LOGI(FORMAT, ...) __android_log_print(ANDROID_LOG_INFO,"TAG",FORMAT,##__VA_ARGS__);
#define LOGE(FORMAT, ...) __android_log_print(ANDROID_LOG_ERROR,"TAG",FORMAT,##__VA_ARGS__);

JavaVM *javaVM;
jobject utils_cls_ref;
jmethodID create_uuid_mid;
/**
 * Android SDK 2.2 后会有此方法
 */
JNIEXPORT jint JNI_OnLoad(JavaVM *vm, void *reserved) {
    LOGE("JNI_OnLoad");
    javaVM = vm;


    return JNI_VERSION_1_6;
}

JNIEXPORT void JNI_OnUnload(JavaVM *vm, void *reserved) {
    LOGE("JNI_OnUnload");

}

//
void *func(void *arg) {
    JNIEnv *env = NULL;
    //通过JavaVM关联当前线程，获取当前线程的JNIEnv
    (*javaVM)->AttachCurrentThread(javaVM, &env, NULL);


    char *no = (char *) arg;
    int i = 0;
    for (int i = 0; i < 10; i++) {
        jobject uuid_obj = (*env)->CallStaticObjectMethod(env, utils_cls_ref, create_uuid_mid);
        char *uuid_cstr = (*env)->GetStringUTFChars(env, uuid_obj, NULL);
        LOGI("%s thread, i:%s\n", no, uuid_cstr);
        (*env)->ReleaseStringUTFChars(env, uuid_obj, uuid_cstr);
    }

    //释放
    (*javaVM)->DetachCurrentThread(javaVM);
    return 1;
};


JNIEXPORT void JNICALL Java_leon_training_thread_jniposix_Client_initJni
        (JNIEnv *env, jclass cls) {
    LOGE("initJni()");
    //初始化找到需要的类，并创建全局引用
    jclass utils_cls = (*env)->FindClass(env, "leon/training/algorithm/Utils");
    utils_cls_ref = (*env)->NewGlobalRef(env, utils_cls);
    create_uuid_mid = (*env)->GetStaticMethodID(
            env,
            utils_cls,
            "createUUID",
            "()Ljava/lang/String;");
}

JNIEXPORT void JNICALL Java_leon_training_thread_jniposix_Client_destroyJni
        (JNIEnv *env, jclass cls) {
    LOGE("destroyJni()");
    //释放
    (*env)->DeleteGlobalRef(env, utils_cls_ref);
}

/**
 * JavaVM
 * 可以通过JavaVM获取到每个线程关联的JNIEnv
 * 每个线程都有独立的JNIEnv
 *
 * 如果获取JavaVM
 * 1.在JNI_OnLoad函数中获取
 * 2.(*env)->
 *
 * 在线程中获取线程的env
 *
 */
JNIEXPORT void JNICALL Java_leon_training_thread_jniposix_Client_pthread
        (JNIEnv *env, jclass cls) {
    LOGE("pthread()");

    pthread_t tid;
    pthread_create(&tid, NULL, func, (void *) "1");
}