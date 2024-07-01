package com.example.draftstreaks.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.location.Geocoder
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.draftstreaks.AppUtils
import com.example.draftstreaks.PreferencesManager
import com.example.draftstreaks.R
import com.example.draftstreaks.constant.Constant
import com.example.draftstreaks.databinding.ActivitySplashBinding
import com.example.draftstreaks.network.NetworkUtils
import com.example.draftstreaks.ui.home.activtiy.homeActivity.HomeActivity
import com.example.draftstreaks.ui.login.LogInActivity
import com.example.draftstreaks.utility.Utils
import com.example.draftstreaks.utility.Utils.Companion.getLastKnownLocation
import java.util.Locale
import javax.inject.Inject


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    lateinit var binding:ActivitySplashBinding
    @Inject
    lateinit var preferencesManager: PreferencesManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_splash)
        preferencesManager= PreferencesManager(this)
       setUpFullScreenStatusBar()
        checkAppPermission()
    }

   fun setUpFullScreenStatusBar(){
      this.window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }
    }

    fun checkAppPermission(){
        val permission = if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.TIRAMISU)
                arrayOf(android.Manifest.permission.POST_NOTIFICATIONS, android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION)
            else
                arrayOf( android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION)
   if (NetworkUtils.isInternetAvailable(this)){
       Utils.checkLocationPermissions(this@SplashActivity,permission) {isUserInAllowedState()}
   }
   else Utils.showNetworkLostAlertDialog(
       this@SplashActivity,
       "No Internet Available"
   ) { checkAppPermission() }
    }
    private fun isUserInAllowedState() {
        val lastLocation = getLastKnownLocation(applicationContext)
        if (lastLocation != null) {
            try {
                // Use Geocoder to get the state from the latitude and longitude
                val geocoder = Geocoder(this, Locale.getDefault())
                val addresses =
                    geocoder.getFromLocation(lastLocation.latitude, lastLocation.longitude, 1)

                // Check if the state is in the allowed list
                val currentState = addresses?.firstOrNull()?.countryCode ?: ""
                if (currentState.lowercase() == "in")
                    checkAppPreferenceSettings()
                else
                    locationError()
            } catch (e: Exception) {
                /*locationError(
                    "Location Error", "There is some issue while getting current location"
                ) { loadPage() }*/
                checkAppPreferenceSettings()
            }
        } else {
            checkAppPreferenceSettings()
        }
    }
    private fun locationError() {
        Utils.showSimpleAlertDialog(
            this@SplashActivity,
            R.drawable.ic_warning,
            "Location Error",
            "This application is only accessible for India only",
            getString(R.string.text_done)
        ) { finishAffinity()}
    }
    private fun checkAppPreferenceSettings() {


    Handler().postDelayed({
        val check: Boolean = preferencesManager.getBoolean(Constant.isLogin)
        val checklogout =preferencesManager.getBoolean(Constant.logout)

        if (check) {

            startActivity(Intent(this, HomeActivity::class.java))
        }
        else if(checklogout) {
            startActivity(Intent(this, LogInActivity::class.java))
            preferencesManager.setBoolean(Constant.isLogin,true)
        }
        else {
            startActivity(Intent(this, UserGuideActivity::class.java))
        }
    }, 1000)
    }


    override fun onRestart() {
        super.onRestart()
        if (!NetworkUtils.isInternetAvailable(this))
            checkAppPermission()
    }

}
