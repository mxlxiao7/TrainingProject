/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class leon_training_ndk_Client */

#ifndef _Included_leon_training_ndk_Client
#define _Included_leon_training_ndk_Client
#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     leon_training_ndk_Client
 * Method:    getStringFromC1
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_leon_training_ndk_Client_getStringFromC1
        (JNIEnv *, jobject);

/*
 * Class:     leon_training_ndk_Client
 * Method:    getStringFromC2
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_leon_training_ndk_Client_getStringFromC2
        (JNIEnv *, jclass);

/*
 * Class:     leon_training_ndk_Client
 * Method:    readStringFromJava
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_leon_training_ndk_Client_readStringFromJava
        (JNIEnv *, jobject);

/*
 * Class:     leon_training_ndk_Client
 * Method:    readStaticStringFromJava
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_leon_training_ndk_Client_readStaticStringFromJava
        (JNIEnv *, jobject);

/*
 * Class:     leon_training_ndk_Client
 * Method:    modifyAtt
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_modifyAtt
        (JNIEnv *, jobject);

/*
 * Class:     leon_training_ndk_Client
 * Method:    modifyStaticAtt
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_modifyStaticAtt
        (JNIEnv *, jobject);

/*
 * Class:     leon_training_ndk_Client
 * Method:    invokeMethod
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_invokeMethod
        (JNIEnv *, jobject);

/*
 * Class:     leon_training_ndk_Client
 * Method:    invokeStaticMethod
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_invokeStaticMethod
        (JNIEnv *, jobject);

/*
 * Class:     leon_training_ndk_Client
 * Method:    invokeConstructMethod
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_invokeConstructMethod
        (JNIEnv *, jobject);

/*
 * Class:     leon_training_ndk_Client
 * Method:    invokeSuperMethod
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_invokeSuperMethod
        (JNIEnv *, jobject);

/*
 * Class:     leon_training_ndk_Client
 * Method:    chineseIssue
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_leon_training_ndk_Client_chineseIssue
        (JNIEnv *, jobject, jstring);

/*
 * Class:     leon_training_ndk_Client
 * Method:    arraySort
 * Signature: ([I)V
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_arraySort
        (JNIEnv *, jobject, jintArray);

/*
 * Class:     leon_training_ndk_Client
 * Method:    getArray
 * Signature: (I)[I
 */
JNIEXPORT jintArray JNICALL Java_leon_training_ndk_Client_getArray
        (JNIEnv *, jobject, jint);


/*
 * Class:     leon_training_ndk_Client
 * Method:    optimizeLocalRef
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_localRef
        (JNIEnv *, jobject);

/*
 * Class:     leon_training_ndk_Client
 * Method:    optimizeWholeRef
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_globalRef
        (JNIEnv *, jobject);

/*
 * Class:     leon_training_ndk_Client
 * Method:    optimizeWholeRef
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_globalWeakRef
        (JNIEnv *, jobject);

/*
 * Class:     leon_training_ndk_Client
 * Method:    optimizeWholeRef
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_exception
        (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif