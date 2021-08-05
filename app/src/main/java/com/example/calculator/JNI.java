package com.example.calculator;

public class JNI {
    static {
        System.loadLibrary("native_lib");
    }
    public native String callCalcu(String mystr);
}
