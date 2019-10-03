package com.burgan.newsapp.repository

import android.content.Context
import android.content.SharedPreferences

class SharedPreference (val context: Context) {
    private val sharedPreference: SharedPreferences = context.getSharedPreferences("Cache", Context.MODE_PRIVATE)

    fun save(KEY_NAME : String,value : String ){
        var editor = sharedPreference.edit()
        editor.putString(KEY_NAME,value )

        return editor.apply()
    }

    fun getValueString(KEY_NAME: String): String? {

        return sharedPreference.getString(KEY_NAME, null)
    }
}