//
// Created by leon on 2017/9/4.
//
#include <android/log.h>

#include "bsdiff.h"
#include "bspatch.h"
#include "patch.h"

#define LOGI(FORMAT, ...) __android_log_print(ANDROID_LOG_INFO,"TAG",FORMAT,##__VA_ARGS__);
#define LOGE(FORMAT, ...) __android_log_print(ANDROID_LOG_ERROR,"TAG",FORMAT,##__VA_ARGS__);


/**
 *  打差分包
 */
JNIEXPORT jint JNICALL Java_leon_training_ndk_patch_Client_bsdiff
        (JNIEnv *env, jclass cls, jstring jold_file, jstring jnew_file, jstring jpatch_file) {
    LOGE("bsdiff()");

    int argc = 4;
    char *cold_file = (*env)->GetStringUTFChars(env, jold_file, NULL);
    char *cnew_file = (*env)->GetStringUTFChars(env, jnew_file, NULL);
    char *cpatch_file = (*env)->GetStringUTFChars(env, jpatch_file, NULL);


    //参数（第一个参数无效）
    char *argv[4];
    argv[0] = "bsdiff";
    argv[1] = cold_file;
    argv[2] = cnew_file;
    argv[3] = cpatch_file;
    bsdiff_main(argc, argv);

    //释放
    (*env)->ReleaseStringUTFChars(env, jold_file, cold_file);
    (*env)->ReleaseStringUTFChars(env, jold_file, cold_file);
    (*env)->ReleaseStringUTFChars(env, jold_file, cold_file);
}

/**
 *  打补丁包
 */
JNIEXPORT jint JNICALL Java_leon_training_ndk_patch_Client_bspatch
        (JNIEnv *env, jclass cls, jstring jold_file, jstring jnew_file, jstring jpatch_file) {
    LOGE("bspatch()");

    int argc = 4;
    char *oldfile = (char *) (*env)->GetStringUTFChars(env, jold_file, NULL);
    char *newfile = (char *) (*env)->GetStringUTFChars(env, jnew_file, NULL);
    char *patchfile = (char *) (*env)->GetStringUTFChars(env, jpatch_file, NULL);

    //参数（第一个参数无效）
    char *argv[4];
    argv[0] = "bspatch";
    argv[1] = oldfile;
    argv[2] = newfile;
    argv[3] = patchfile;

    bspatch_main(argc, argv);

    (*env)->ReleaseStringUTFChars(env, jold_file, oldfile);
    (*env)->ReleaseStringUTFChars(env, jnew_file, newfile);
    (*env)->ReleaseStringUTFChars(env, jpatch_file, patchfile);
}