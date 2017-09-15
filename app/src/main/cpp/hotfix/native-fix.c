//
// Created by leon on 2017/9/14.
//

#include <stdio.h>
#include <stdlib.h>
#include <android/log.h>
#define LOGI(FORMAT, ...) __android_log_print(ANDROID_LOG_INFO,"TAG",FORMAT,##__VA_ARGS__);
#define LOGE(FORMAT, ...) __android_log_print(ANDROID_LOG_ERROR,"TAG",FORMAT,##__VA_ARGS__);

#include "native-fix.h"



/*
 * Class:     leon_training_ndk_hotfix_NativeFix
 * Method:    init
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_hotfix_NativeFix_init
        (JNIEnv *env, jclass cls, jint api){



}

/*
 * Class:     leon_training_ndk_hotfix_NativeFix
 * Method:    replaceMethod
 * Signature: (Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_hotfix_NativeFix_replaceMethod
        (JNIEnv *env, jclass cls, jobject method_src, jobject method_res){

}