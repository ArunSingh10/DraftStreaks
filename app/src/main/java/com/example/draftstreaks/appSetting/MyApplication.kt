package com.example.draftstreaks.appSetting

import android.annotation.SuppressLint
import android.app.Application
import android.provider.Settings
import android.util.Log
import com.example.draftstreaks.PreferencesManager
import com.example.draftstreaks.constant.Constant
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application()  {

    private lateinit var preferencesManager : PreferencesManager
    private var fcmToken = ""
    private var uniqueDeviceId = ""


    override fun onCreate() {
        super.onCreate()

        preferencesManager = PreferencesManager(applicationContext)
        fcmToken = preferencesManager.getString(Constant.fcmToken).toString()
        uniqueDeviceId = preferencesManager.getString(Constant.uniqueDeviceId).toString()

        Log.d("fcmToken", fcmToken)
        Log.d("uniqueDeviceId", uniqueDeviceId)

        if(fcmToken.isEmpty() || uniqueDeviceId.isEmpty()){
            getFirebaseToken()
        }

    }

    @SuppressLint("HardwareIds")
    private fun getFirebaseToken() {

        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            if (it.isSuccessful) {
                fcmToken = it.result.toString()
                preferencesManager.setString(Constant.fcmToken, fcmToken)

            }
            else{
                Log.w("fcmTokenError", "Fetching FCM registration token failed", it.exception)
                //return@OnCompleteListener
            }
        }

        uniqueDeviceId = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        preferencesManager.setString(Constant.uniqueDeviceId, uniqueDeviceId)
    }

}