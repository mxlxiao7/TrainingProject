#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_leon_training_ndk_Client_getStringFromCPlus(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
