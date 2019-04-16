package com.exceptionteam17.budgethelper.util

import android.util.Log

class MLog {
    companion object {
        private const val TAG : String = "Budget Helper "

        var isDebuggable: Boolean = true  // false // set this in main activity  ////             MyLog.isDebuggable = 0 != applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE

        fun e(text : String){
            if(isDebuggable)
            Log.e(TAG, text + " --> " + Throwable().stackTrace[1])
        }
        fun e(tag:String,text : String){
            if(isDebuggable)
            Log.e(tag, text + " --> " + Throwable().stackTrace[1])
        }
        fun i(text : String){
            if(isDebuggable)
            Log.i(TAG, text + " --> " + Throwable().stackTrace[1])
        }
        fun i(tag:String,text : String){
            if(isDebuggable)
            Log.i(tag, text + " --> " + Throwable().stackTrace[1])
        }
    }
}
