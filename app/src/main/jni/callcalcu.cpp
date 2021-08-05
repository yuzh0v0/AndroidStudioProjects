//
// Created by yuzonghang on 2021-07-23.
//
#include <jni.h>
#include "calculator.cpp"
#include <android/log.h>
#define  LOG_TAG    "CPP_LOG"
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)

//  transform jstring into string
string jstringTostring(JNIEnv* env, jstring jstr) {
    char *rtn = nullptr;
    jclass clsstring = env->FindClass("java/lang/String");
    jstring strencode = env->NewStringUTF("GB2312");
    jmethodID mid = env->GetMethodID(clsstring, "getBytes", "(Ljava/lang/String;)[B");
    auto barr = (jbyteArray) env->CallObjectMethod(jstr, mid, strencode);
    jsize alen = env->GetArrayLength(barr);
    jbyte *ba = env->GetByteArrayElements(barr, JNI_FALSE);
    if (alen > 0) {
        rtn = (char *) malloc(alen + 1);
        memcpy(rtn, ba, alen);
        rtn[alen] = 0;
    }
    env->ReleaseByteArrayElements(barr, ba, 0);
    std::string stemp(rtn);
    free(rtn);
    return stemp;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_calculator_JNI_callCalcu(JNIEnv *env, jobject thiz, jstring inputStr) {
    string inputString = jstringTostring(env, inputStr);
    const int len = inputString.length();
    char* input ;
    input = new char[len+1];
    strcpy(input, inputString.c_str());

    // call C++ algorithm
    FourArithmeticOP cal;
    string ispass = cal.InorderToPost(input);
    free(input);

    // settle output
    const char* output;
    if(ispass=="pass"){
        string temp_output = cal.Calculate();
        output = temp_output.c_str();
        LOGI("%s", output);
    }else{
        output = ispass.c_str();
        LOGI("%s", output);
    }
    return env->NewStringUTF(output);
}