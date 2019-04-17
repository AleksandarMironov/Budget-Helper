package com.exceptionteam17.budgethelper

import android.content.pm.ApplicationInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exceptionteam17.budgethelper.util.MLog
import com.exceptionteam17.budgethelper.util.toDateAndSum
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MLog.isDebuggable = 0 != applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE

        // test barcode info
        val info = "00123456*0000254*2017-11-25*18:39:04*107.11"
        info.toDateAndSum()
    }
}

