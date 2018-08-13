package com.jerome.tvfocus;

import android.util.Log;

/**
 * 可输出类名、方法名、行号的log工具
 *
 * @author JeromeLiee
 * @date 2018/8/11.
 */

public class JLog {
    private static final String LOG_TAG = "TVFocus";
    private static String className;
    private static String methodName;
    private static int lineNumber;
    private static boolean sIsDebug;

    public static void init(boolean isDebug) {
        sIsDebug = isDebug;
    }

    public static void v(String message) {
        if (isDebug()) {
            getMethodNames((new Throwable()).getStackTrace());
            Log.v(LOG_TAG, createLog(message));
        }
    }

    public static void v(String message, boolean isToggle) {
        if (isToggle || isDebug()) {
            getMethodNames((new Throwable()).getStackTrace());
            Log.v(LOG_TAG, createLog(message));
        }
    }

    public static void d(String message) {
        if (isDebug()) {
            getMethodNames((new Throwable()).getStackTrace());
            Log.d(LOG_TAG, createLog(message));
        }
    }

    public static void d(String message, boolean isToggle) {
        if (isToggle || isDebug()) {
            getMethodNames((new Throwable()).getStackTrace());
            Log.d(LOG_TAG, createLog(message));
        }
    }

    public static void i(String message) {
        if (isDebug()) {
            getMethodNames((new Throwable()).getStackTrace());
            Log.i(LOG_TAG, createLog(message));
        }
    }

    public static void i(String message, boolean isToggle) {
        if (isToggle || isDebug()) {
            getMethodNames((new Throwable()).getStackTrace());
            Log.i(LOG_TAG, createLog(message));
        }
    }

    public static void w(String message) {
        if (isDebug()) {
            getMethodNames((new Throwable()).getStackTrace());
            Log.w(LOG_TAG, createLog(message));
        }
    }

    public static void w(String message, boolean isToggle) {
        if (isToggle || isDebug()) {
            getMethodNames((new Throwable()).getStackTrace());
            Log.w(LOG_TAG, createLog(message));
        }
    }

    public static void e(String message) {
        if (isDebug()) {
            getMethodNames((new Throwable()).getStackTrace());
            Log.e(LOG_TAG, createLog(message));
        }
    }

    public static void e(String message, boolean isToggle) {
        if (isToggle || isDebug()) {
            getMethodNames((new Throwable()).getStackTrace());
            Log.e(LOG_TAG, createLog(message));
        }
    }

    public static void e(String message, Throwable tr) {
        if (isDebug()) {
            getMethodNames((new Throwable()).getStackTrace());
            Log.e(LOG_TAG, createLog(message), tr);
        }
    }

    public static void e(String message, Throwable tr, boolean isToggle) {
        if (isToggle || isDebug()) {
            getMethodNames((new Throwable()).getStackTrace());
            Log.e(LOG_TAG, createLog(message), tr);
        }
    }

    private static boolean isDebug() {
        return sIsDebug;
    }

    private static String createLog(String log) {
        return "[" + className + ":" + methodName + "+" + lineNumber + "]" + log;
    }

    private static void getMethodNames(StackTraceElement[] sElements) {
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }

}
