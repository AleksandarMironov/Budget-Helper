package com.exceptionteam17.budgethelper.util

import java.text.SimpleDateFormat
import java.util.*

class Utils {

}

//convert barcode info to long date and double price
public fun String.toDateAndSum(): Pair<Long, Double>  {
    val data = this.split("*")
    return Pair(SimpleDateFormat("yyyy-MM-dd/HH:mm:ss", Locale.getDefault()).parse("${data[2]}/${data[3]}").time, data[4].toDouble())
}