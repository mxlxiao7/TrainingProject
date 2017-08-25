//
// Created by leon on 2017/8/23.
//

#include "jnilog.h"
#include "native-c.h"
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <android/log.h>





/**
 *  C 生成字符串并返回 (非静态方法)
 */
JNIEXPORT jstring JNICALL Java_leon_training_ndk_Client_getStringFromC1
        (JNIEnv *env, jobject obj) {
    return (*env)->NewStringUTF(env, "C String");
}


/**
 *  C 生成字符串并返回 (静态方法)
 *  主要区别是 静态方法生成参数jclass，非静态生成jobject
 */
JNIEXPORT jstring JNICALL Java_leon_training_ndk_Client_getStringFromC2
        (JNIEnv *env, jclass cls) {
    return (*env)->NewStringUTF(env, "C String");
}


/**
 *  C读取java实例属性，并返回
 *
 *  实例属性都是通过 (*env)->Get***Field
 *
 */
JNIEXPORT jstring JNICALL Java_leon_training_ndk_Client_readStringFromJava
        (JNIEnv *env, jobject jobj) {
    //1.首先拿到类class
    jclass cls = (*env)->GetObjectClass(env, jobj);

    //2.取目标属性对应的ID
    jfieldID id = (*env)->GetFieldID(env, cls, "name", "Ljava/lang/String;");

    //3.取目标属性值
    jstring jstr = (*env)->GetObjectField(env, jobj, id);

    //4.转换 java -> c
    //isCopy 是否复制目标字符串
    jboolean isCopy = NULL;
    //函数内部复制了，isCopy:JNI_TRUE 没有复制:JNI_FALSE (如果不关心这个可以传NULL)
    char *old = (*env)->GetStringUTFChars(env, jstr, &isCopy);
    char *is_copy = isCopy ? " 复制了 " : " 没有复制 ";
    showmessage(env, is_copy);

    //5.修改(super + old)
    char str[50] = {"Handsome "};
    strcat(str, old);

    //6.C -> java
    jstring value = (*env)->NewStringUTF(env, str);

    //回收内存
    (*env)->ReleaseStringUTFChars(env, jstr, old);
    return value;
}

/**
 *  C读取Java类静态属性
 *  静态属性都是通过 (*env)->GetStatic***Field
 *
 */
JNIEXPORT jstring JNICALL Java_leon_training_ndk_Client_readStaticStringFromJava
        (JNIEnv *env, jobject jobj) {
    jclass cls = (*env)->GetObjectClass(env, jobj);

    //1.取目标属性对应的ID
    jfieldID id = (*env)->GetStaticFieldID(env, cls, "otherName", "Ljava/lang/String;");

    //2.取目标属性值
    jstring jstr = (*env)->GetStaticObjectField(env, cls, id);

    //3.转换 java -> c
    //isCopy 是否复制目标字符串（一般写NULL）
    char *old = (*env)->GetStringUTFChars(env, jstr, NULL);

    //4.修改(super + old)
    char str[50] = {"Beautiful "};
    strcat(str, old);

    //5.C -> java
    jstring value = (*env)->NewStringUTF(env, str);

    return value;
}

/**
 *  C修改Java类实例变量
 *  修改Java实例属性：(*env)->Set***Field
 *
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_modifyAtt
        (JNIEnv *env, jobject jobj) {

//1.首先拿到类class
    jclass cls = (*env)->GetObjectClass(env, jobj);

    //2.取目标属性对应的ID
    jfieldID id = (*env)->GetFieldID(env, cls, "name", "Ljava/lang/String;");

    //3.取目标属性值
    jstring jstr = (*env)->GetObjectField(env, jobj, id);

    //4.转换 java -> c
    //isCopy 是否复制目标字符串（一般写NULL）
    char *old = (*env)->GetStringUTFChars(env, jstr, NULL);

    //5.修改(super + old)
    char str[50] = {"Handsome "};
    strcat(str, old);

    //6.C -> java
    jstring value = (*env)->NewStringUTF(env, str);

    //7.修改属性
    (*env)->SetObjectField(env, jobj, id, value);
}

/**
 *  C修改Java类静态变量
 *  修改Java静态属性：(*env)->SetStatic***Field
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_modifyStaticAtt
        (JNIEnv *env, jobject jobj) {
    //1.取class
    jclass cls = (*env)->GetObjectClass(env, jobj);

    //2.取目标属性对应的ID
    jfieldID id = (*env)->GetStaticFieldID(env, cls, "otherName", "Ljava/lang/String;");

    //3.取目标属性值
    jstring jstr = (*env)->GetStaticObjectField(env, cls, id);

    //4.转换 java -> c
    //isCopy 是否复制目标字符串（一般写NULL）
    char *old = (*env)->GetStringUTFChars(env, jstr, NULL);

    //5.修改(super + old)
    char str[50] = {"Beautiful "};
    strcat(str, old);

    //6.C -> java
    jstring value = (*env)->NewStringUTF(env, str);

    //7.修改属性
    (*env)->SetStaticObjectField(env, cls, id, value);
}

/**
 *  C调用Java实例方法
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_invokeMethod
        (JNIEnv *env, jobject jobj) {
    //1.取class
    jclass cls = (*env)->GetObjectClass(env, jobj);
    //2.取目标方法对应的ID
    jmethodID id = (*env)->GetMethodID(env, cls, "cInvokeJavaMethod", "(I)I");
    //3.调用目标方法
    jint random = (*env)->CallIntMethod(env, jobj, id, 200);

    char s[50];
    sprintf(s, "Random Num = %d", random);
    showmessage(env, s);
}


/**
 *  C调用Java静态方法
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_invokeStaticMethod
        (JNIEnv *env, jobject jobj) {
    //1.取class
    jclass cls = (*env)->GetObjectClass(env, jobj);
    //2.取目标方法对应的ID
    jmethodID id = (*env)->GetStaticMethodID(env, cls, "cInvokeJavaStaticMethod",
                                             "()Ljava/lang/String;");
    //3.调用目标方法
    jstring uuid = (*env)->CallStaticObjectMethod(env, cls, id);
    char s[100];
    sprintf(s, "UUID = %ld", uuid);
    showmessage(env, s);
}


/**
 *  C调用Java构造方法
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_invokeConstructMethod
        (JNIEnv *env, jobject jobj) {
    jclass selfCls = (*env)->GetObjectClass(env, jobj);

    //生成Java Date
    jclass cls = (*env)->FindClass(env, "java/util/Date");
    jmethodID construct_mid = (*env)->GetMethodID(env, cls, "<init>", "()V");
    jobject java_date = (*env)->NewObject(env, cls, construct_mid);

    //调用getTime方法
    jmethodID gettime_mid = (*env)->GetMethodID(env, cls, "getTime", "()J");
    jlong time = (*env)->CallLongMethod(env, java_date, gettime_mid);
    char s[100];
    sprintf(s, "时间戳 = %ld", time);
    showmessage(env, s);
}

/**
 *  C调用Java父类方法
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_invokeSuperMethod
        (JNIEnv *env, jobject jobj) {
    //获取god属性对象
    jclass cls = (*env)->GetObjectClass(env, jobj);
    jfieldID god_id = (*env)->GetFieldID(env, cls, "god", "Lleon/training/ndk/God;");
    jobject obj = (*env)->GetObjectField(env, jobj, god_id);

    //调用子类方法
    jclass jack_cls = (*env)->GetObjectClass(env, obj);
    jmethodID mid = (*env)->GetMethodID(env, jack_cls, "sayHi", "()V");
    (*env)->CallVoidMethod(env, obj, mid);

    //寻找父类并调用父类方法
    jclass god_cls = (*env)->FindClass(env, "leon/training/ndk/God");
    mid = (*env)->GetMethodID(env, god_cls, "sayHi", "()V");
    (*env)->CallNonvirtualVoidMethod(env, obj, god_cls, mid);
}

/**
 *  中文乱码问题
 */
JNIEXPORT jstring JNICALL Java_leon_training_ndk_Client_chineseIssue
        (JNIEnv *env, jobject jobj, jstring jstr) {

    //Java -> C 没有问题
    //char *c_str0 = (*env)->GetStringUTFChars(env, jstr, NULL);

    //此处可能会出现乱码问题
    //char *c_str = "马蓉与宋喆";
    //jstring j_str = (*env)->NewStringUTF(env, c_str);
    //return j_str;

    //可通过Java String(byte[],charset); 解决
    char *c_str = "马蓉与宋喆";
    jclass str_cls = (*env)->FindClass(env, "java/lang/String");
    jmethodID con_mid = (*env)->GetMethodID(
            env,
            str_cls,
            "<init>",
            "([BLjava/lang/String;)V");
    //jbyte -> char
    //jbyteArray -> char[]
    jbyteArray bytes = (*env)->NewByteArray(env, strlen(c_str));

    //byte数组赋值
    //0->strlen(c_str),从头到尾
    //对等于，从c_str这个字符数组，复制到bytes这个字符数组
    (*env)->SetByteArrayRegion(env, bytes, 0, strlen(c_str), c_str);

    //字符编码
    jstring charset_name = (*env)->NewStringUTF(env, "UTF8");
    jstring value = (*env)->NewObject(env, str_cls, con_mid, bytes, charset_name);
    return value;
}


int compare(int *a, int *b) {
    return (*a) - (*b);
}

/**
 *  传入数组，同步数组数据
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_arraySort
        (JNIEnv *env, jobject j_obj, jintArray j_int_arr) {
    //jintArray -> jing指针 -> c int 数组
    jint *elems = (*env)->GetIntArrayElements(env, j_int_arr, JNI_FALSE);
    //数组的长度
    int len = (*env)->GetArrayLength(env, j_int_arr);
    //排序
    qsort(elems, len, sizeof(jint), compare);
    //同步
    // 0 : Java数组更新，并且释放C/C++数组
    // JNI_ABORT, Java数组不进行更新，但释放C/C++数组
    // JNI_COMMIT, Java数组进行更新，但不释放C/C++数组
    (*env)->ReleaseIntArrayElements(env, j_int_arr, elems, 0);
}

/**
 *  返回数组
 */
JNIEXPORT jintArray JNICALL Java_leon_training_ndk_Client_getArray
        (JNIEnv *env, jobject jobj, jint len) {
    //new Java array
    jintArray j_arr = (*env)->NewIntArray(env, len);

    //new c array
    jint *c_arr = (*env)->GetIntArrayElements(env, j_arr, NULL);
    for (int i = 0; i < len; i++) {
        c_arr[i] = i;
    }

    //同步
    (*env)->ReleaseIntArrayElements(env, j_arr, c_arr, 0);

    return j_arr;
}


/**
 *  局部引用优化(释放内存)
 *  使用场景：
 *      1.访问了一个很大的对象，访问完后还会有复杂耗时的操作
 *      2.创建了大量的局部引用，后面不在使用
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_localRef
        (JNIEnv *env, jobject jobj) {

    for (int i = 0; i < 5; i++) {
        jclass cls = (*env)->FindClass(env, "java/util/Date");
        jmethodID mid = (*env)->GetMethodID(env, cls, "<init>", "()V");
        jobject obj = (*env)->NewObject(env, cls, mid);

        //不再使用obj对象了，通知回收
        (*env)->DeleteLocalRef(env, obj);
    }
}


jstring glo_str;
/**
 *  全局引用优化(释放内存)
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_globalRef
        (JNIEnv *env, jobject jobj) {
    //创建
    jstring j_str = (*env)->NewStringUTF(env, "全局引用使用：飞雪连天射白鹿");
    glo_str = (*env)->NewGlobalRef(env, j_str);

    //使用
    jclass cls = (*env)->GetObjectClass(env, jobj);
    char *s = (*env)->GetStringUTFChars(env, j_str, NULL);
    showmessage(env, s);

    //回收
    (*env)->DeleteGlobalRef(env, glo_str);
}


jstring weak_glo_str;
/**
 *  弱全局引用优化(释放内存)
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_globalWeakRef
        (JNIEnv *env, jobject jobj) {
    //创建
    jstring j_str = (*env)->NewStringUTF(env, "弱全局引用使用：AAAAAA");
    weak_glo_str = (*env)->NewWeakGlobalRef(env, j_str);

    //使用
    jclass cls = (*env)->GetObjectClass(env, jobj);
    char *s = (*env)->GetStringUTFChars(env, j_str, NULL);
    showmessage(env, s);

    //回收
    (*env)->DeleteWeakGlobalRef(env, weak_glo_str);
}

/**
 *  JNI Exception  jni抛出的异常为Java Throwable异常
 */
JNIEXPORT void JNICALL Java_leon_training_ndk_Client_exception
        (JNIEnv *env, jobject jobj) {
    jclass cls = (*env)->GetObjectClass(env, jobj);
    jfieldID fid = (*env)->GetFieldID(env, cls, "key2", "Ljava/lang/String;");

    jthrowable exception = (*env)->ExceptionOccurred(env);
    if (exception != NULL) {
        (*env)->ExceptionClear(env);
        showmessage(env, "C 发现异常并清空");
        fid = (*env)->GetFieldID(env, cls, "key", "Ljava/lang/String;");
    }

    jstring jstr = (*env)->GetObjectField(env, jobj, fid);
    char *str = (*env)->GetStringUTFChars(env, jstr, NULL);

    if (strcasecmp(str, "super jason") != 0) {
        showmessage(env, "C 抛出异常");
        jclass newExcCls = (*env)->FindClass(env, "java/lang/IllegalArgumentException");
        (*env)->ThrowNew(env, newExcCls, "key's value is invalid!");
    }
}