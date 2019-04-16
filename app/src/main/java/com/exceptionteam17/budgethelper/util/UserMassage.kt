package com.exceptionteam17.budgethelper.util

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.exceptionteam17.budgethelper.R


class UserMassage {

    constructor(context: Context, text: String, type: Int) {
        showMassage(context, text, type)

    }

    constructor(context: Context, textId: Int, type: Int) {
        showMassage(context, context.resources.getString(textId), type)
    }

    @SuppressLint("InflateParams")
    private fun showMassage(context: Context, text: String, type: Int) {
        Handler(Looper.getMainLooper()).post {
            val toast = Toast.makeText(context, "  $text  ", Toast.LENGTH_LONG)
            val inflater = LayoutInflater.from(context)
            val mview = inflater.inflate(R.layout.user_massage, null)
            when (type){
                INFO -> {
                    mview.findViewById<ImageView>(R.id.image).setImageResource(R.drawable.ic_info_circle_white)
                }
                WARNING -> {
                    mview.findViewById<ImageView>(R.id.image).setImageResource(R.drawable.ic_warning_white)
                }
                ERROR -> {
                    mview.findViewById<ImageView>(R.id.image).setImageResource(R.drawable.ic_warning_notification_uired_active)
                }
            }
            mview.findViewById<TextView>(R.id.text).text = text
            toast.view = mview
            toast.setGravity(Gravity.FILL_HORIZONTAL or Gravity.BOTTOM, 0, 0)
            toast.show()
        }
    }

    companion object {
        const val INFO = 0
        const val WARNING = 1
        const val ERROR = 2
    }

}
