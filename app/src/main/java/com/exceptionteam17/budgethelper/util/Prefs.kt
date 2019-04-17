package com.exceptionteam17.budgethelper.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class Prefs private constructor(private val context: Context) {
    companion object {

        const val SHOULD_RUN = "should_run"

        @SuppressLint("StaticFieldLeak")
        private var instance: Prefs? = null

        fun getInstance(context: Context): Prefs {
            if (instance == null) instance = Prefs(context.applicationContext) //this prevents memory leak

            return instance!!
        }
    }

    private val prefs = PreferenceManager.getDefaultSharedPreferences(context)
    

    var isEnabled: Boolean
        get() = getBoolean(SHOULD_RUN, false)
        set(value) {
            putBoolean(SHOULD_RUN, value)
        }

    fun getBoolean(key: String, def: Boolean) = prefs.getBoolean(key, def)
    fun getFloat(key: String, def: Float) = prefs.getFloat(key, def)
    fun getInt(key: String, def: Int) = prefs.getInt(key, def)
    fun getString(key: String, def: String? = null) = prefs.getString(key, def)
    fun getStringSet(key: String, def: Set<String>) = prefs.getStringSet(key, def)

    fun remove(key: String) = prefs.edit().remove(key).apply()

    fun putBoolean(key: String, value: Boolean) = prefs.edit().putBoolean(key, value).apply()
    fun putFloat(key: String, value: Float) = prefs.edit().putFloat(key, value).apply()
    fun putInt(key: String, value: Int) = prefs.edit().putInt(key, value).apply()
    fun putString(key: String, value: String?) = prefs.edit().putString(key, value).apply()
    fun putStringSet(key: String, set: Set<String>) = prefs.edit().putStringSet(key, set).apply()

    fun registerOnSharedPreferenceChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) =
            prefs.registerOnSharedPreferenceChangeListener(listener)

    fun unregisterOnSharedPreferenceChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) =
            prefs.unregisterOnSharedPreferenceChangeListener(listener)
}