package com.example.calculator;

public class JNI {
    {
        // 在这里我们需要加载这个jni so库， 就是最终编译产出的so的名字
        System.loadLibrary("native_lib");
    }
    public native String callcalcu(String mystr);
}
