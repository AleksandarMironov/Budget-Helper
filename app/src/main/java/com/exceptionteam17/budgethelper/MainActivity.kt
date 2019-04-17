package com.exceptionteam17.budgethelper

import android.content.pm.ApplicationInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exceptionteam17.budgethelper.util.MLog
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MLog.isDebuggable = 0 != applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE

        // test barcode info
        val info = "00123456*0000254*2017-11-25*18:39:04*107.11"
    }

}


//convert barcode info to long date and double price
public fun String.toDateAndSum(): Pair<Long, Double>  {
    val data = this.split("*")
    return Pair(SimpleDateFormat("yyyy-MM-dd/HH:mm:ss", Locale.getDefault()).parse("${data[2]}/${data[3]}").time, data[4].toDouble())
}
