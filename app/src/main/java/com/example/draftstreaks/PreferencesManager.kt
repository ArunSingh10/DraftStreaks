package com.example.draftstreaks

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PreferencesManager @Inject constructor (@ApplicationContext context : Context) {

    private  var sharedPreferences  = context.getSharedPreferences(context.getString(R.string.app_name),
        Context.MODE_PRIVATE
    )
    private val editor = sharedPreferences.edit()

    fun setString(key : String, value : String){
        editor.putString(key, value)
        editor.apply()
    }

    fun getString(key : String) : String? {
        return sharedPreferences.getString(key,"")
    }

    fun setBoolean(key : String, value : Boolean){
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBoolean(key : String) : Boolean {
        return sharedPreferences.getBoolean(key,false)
    }

    fun clearData(){
        editor.clear()
        editor.apply()
    }

}