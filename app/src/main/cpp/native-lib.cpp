#include <jni.h>
#include <string>
#include <android/log.h>

#define LOGI(FORMAT, ...) __android_log_print(ANDROID_LOG_INFO,"TAG",FORMAT,##__VA_ARGS__);
#define LOGE(FORMAT, ...) __android_log_print(ANDROID_LOG_ERROR,"TAG",FORMAT,##__VA_ARGS__);


extern "C"
JNIEXPORT jstring JNICALL
Java_leon_training_ndk_Client_getStringFromCPlus(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    LOGE("getStringFromCPlus()");
    return env->NewStringUTF(hello.c_str());
}
