//
// Created by leon on 2017/8/25.
//

#include "jnilog.h"

void showCharMsg(JNIEnv *env, char *s) {
    jclass log_cls = (*env)->FindClass(env, "leon/training/ndk/JniLog");

    jmethodID id = (*env)->GetStaticMethodID(env, log_cls, "showMessage", "(Ljava/lang/String;)V");
    if (id == NULL) {
        return;
    }
    jstring msg = (*env)->NewStringUTF(env, s);
    (*env)->CallStaticVoidMethod(env, log_cls, id, msg);
}

void showStrMsg(JNIEnv *env,jstring msg) {
    jclass log_cls = (*env)->FindClass(env, "leon/training/ndk/JniLog");

    jmethodID id = (*env)->GetStaticMethodID(env, log_cls, "showMessage", "(Ljava/lang/String;)V");
    if (id == NULL) {
        return;
    }
    (*env)->CallStaticVoidMethod(env, log_cls, id, msg);
}