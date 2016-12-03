package com.example.a64.viewapp.Utils;

import android.util.Log;

import static com.example.a64.viewapp.Utils.Constant.DEBUG;

/**
 * Created by 64 on 03/12/2016.
 */

public class Logger {

    public void logError(String Mensaje){
        if (DEBUG){
            //Thread.currentThread() --> devuelve una referencia al hilo
            String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
            String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
            String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
            int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();

            Log.e(className + "." + methodName + "():" + lineNumber, Mensaje);
        }
    }

    public  void logDebug(String Mensaje){
        if (DEBUG){
            String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
            String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
            String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
            int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();

            Log.d(className + "." + methodName + "():" + lineNumber, Mensaje);
        }
    }
}
