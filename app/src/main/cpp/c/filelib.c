//
// Created by leon on 2017/8/25.
//

#include "jnilog.h"
#include "filelib.h"
#include <string.h>
#include <stdio.h>
#include <stdlib.h>


long get_file_size(char *file) {
    FILE *fp = fopen(file, "rb");
    fseek(fp, 0, SEEK_END);
    long size = ftell(fp);
    fclose(fp);
    return size;
}

/**
 * 分割文件
 */
JNIEXPORT jint JNICALL Java_leon_training_ndk_splistmerge_Client_splitFile
        (JNIEnv *env, jclass cls, jstring path, jstring pattern, jint count) {
    //源文件路径
    const char *c_path = (*env)->GetStringUTFChars(env, path, NULL);
    const char *c_pattern = (*env)->GetStringUTFChars(env, pattern, NULL);

    //分割文件列表
    char **patches = malloc(sizeof(char *) * count);

    //
    char *split_file;
    for (int i = 0; i < count; i++) {
        split_file = patches[i] = malloc(sizeof(char) * 100);

        //元素
        //源文件：/src/video.mp4
        //目标文件：/src/video_%d.mp4
        sprintf(patches[i], c_pattern, i);
        showmessage(env, patches[i]);
    }

    FILE *fp = fopen(c_path, "r");
    if (fp == NULL) {
        showmessage(env, "src fp is null");
    }

    long file_size = get_file_size(c_path);
    FILE *src_fp = fopen(c_path, "rb");

    //计算分割文件后每个文件大小
    if (file_size % count == 0) {
        int item_len = file_size / count;
        for (int i = 0; i < count; i++) {
            //写文件
            FILE *w_fp = fopen(patches[i], "wb");
            for (int j = 0; j < item_len; j++) {
                fputc(fgetc(src_fp), w_fp);
            }

            //关闭写文件
            fclose(w_fp);
        }
    } else {
        int item_len = file_size / (count - 1);
        for (int i = 0; i < count - 1; i++) {
            //写文件
            FILE *w_fp = fopen(patches[i], "wb");

            for (int j = 0; j < item_len; j++) {
                fputc(fgetc(src_fp), w_fp);
            }

            //关闭写文件
            fclose(w_fp);
        }

        FILE *w_fp = fopen(patches[count - 1], "wb");
        for (int j = 0; j < file_size % (count - 1); j++) {
            fputc(fgetc(src_fp), w_fp);
        }
        fclose(w_fp);
    }


    //释放
    fclose(src_fp);
    (*env)->ReleaseStringUTFChars(env, path, c_path);
    (*env)->ReleaseStringUTFChars(env, pattern, c_pattern);

    for (int i = 0; i < count; i++) {
        free(patches[i]);
    }
    free(patches);

    return 0;
}

/**
 * 文件合并
 */
JNIEXPORT jint JNICALL Java_leon_training_ndk_splistmerge_Client_mergeFile
        (JNIEnv *env, jclass cls, jstring target_path, jstring pattern,
         jint count) {
    //源文件路径
    const char *c_target = (*env)->GetStringUTFChars(env, target_path, NULL);
    const char *c_pattern = (*env)->GetStringUTFChars(env, pattern, NULL);


    //列出合并文件列表
    char **patches = malloc(sizeof(char *) * count);

    for (int i = 0; i < count; i++) {
        patches[i] = malloc(sizeof(char) * 100);
        sprintf(patches[i], c_pattern, i);

    }

    //目标文件
    FILE *target_fp = fopen(c_target, "wb");

    for (int i = 0; i < count; i++) {
        FILE *item_fp = fopen(patches[i], "rb");

        int c = 0;
        while ((c = fgetc(item_fp)) != EOF) {
            fputc(c, target_fp);
        }

        fclose(item_fp);
        showmessage(env, patches[i]);
    }

    //释放
    fclose(target_fp);
    (*env)->ReleaseStringUTFChars(env, target_path, c_target);
    (*env)->ReleaseStringUTFChars(env, pattern, c_pattern);

    for (int i = 0; i < count; i++) {
        free(patches[i]);
    }
    free(patches);

    return 0;
}