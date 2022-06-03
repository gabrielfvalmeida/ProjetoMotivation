package com.example.projeto_motivation.infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

    private val security: SharedPreferences = context.getSharedPreferences("Motivation",Context.MODE_PRIVATE)

    fun storeStr(key: String, str: String) {
        security.edit().putString(key, str).apply()
    }

    fun getStr(key: String):String {
        return security.getString(key,"") ?: ""
    }

    fun clearStr(key: String) {
        security.edit().putString(key, "").apply()
        //security.edit().clear().apply()      pode ser assim tb
    }

}