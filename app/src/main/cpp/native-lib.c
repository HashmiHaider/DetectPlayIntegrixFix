#include <jni.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <android/log.h>
#include <sys/stat.h>

#define LOG_TAG "IntegrityCheck"
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)

// Check if PlayIntegrityFix
jboolean checkPlayIntegrityFix() {
    // Check for PlayIntegrityFix
    const char *suspect_paths[] = {
            "/data/adb/modules/PlayIntegrityFix",
            "/system/xbin/su",
            "/system/bin/su",
            "/system/app/Superuser",
            "/system/bin/.ext/.su",
            "/system/xbin/mu"
    };

    struct stat fileStat;
    for (int i = 0; i < sizeof(suspect_paths) / sizeof(suspect_paths[0]); i++) {
        if (stat(suspect_paths[i], &fileStat) == 0) {
            LOGE("Detected suspicious file: %s", suspect_paths[i]);
            return JNI_TRUE; // Detected
        }
    }

    return JNI_FALSE; // Not detected
}

// JNI wrapper
JNIEXPORT jboolean JNICALL
Java_com_example_assessment1_IntegrityChecker_detectPlayIntegrityFix(JNIEnv *env, jobject obj) {
    return checkPlayIntegrityFix();
}
