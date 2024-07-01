package com.example.draftstreaks.utility

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.location.Location
import android.location.LocationManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.draftstreaks.R

import com.example.draftstreaks.network.ApiEndPoint

import com.ficat.easypermissions.EasyPermissions
import com.tapadoo.alerter.Alerter
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


class Utils {
    companion object {

        fun getBitmapFromUrl(imageUrl: String?): Bitmap? {
            return try {
                val url = URL(imageUrl)
                val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
                connection.doInput = true
                connection.connect()
                val input: InputStream = connection.getInputStream()
                BitmapFactory.decodeStream(input)
            } catch (e: Exception) {
                Log.e("awesome", "Error in getting notification image: " + e.localizedMessage)
                null
            }
        }

        fun loadImage(
            activity: Activity,
            image: ImageView,
            imageUrl: String?,
            defaultImage: Int
        ) {

            Glide.with(activity)
                .load(ApiEndPoint.LIVE_BASE_URL + imageUrl)
                .listener(object : RequestListener<Drawable> {

                    override fun onResourceReady(
                        resource: Drawable,
                        model: Any,
                        target: Target<Drawable>?,
                        dataSource: DataSource,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }
                })
                .placeholder(defaultImage)
                //.centerInside()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(image)

        }

        fun hideKeyboard(context: Context) {
            val currentFocusedView: View? = (context as Activity).currentFocus
            currentFocusedView?.let {
                val inputMethodManager: InputMethodManager =
                    context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
            }
        }

        fun showErrorMessage(activity: Activity, error: String) {
            hideKeyboard(activity)
            Alerter.create(activity)
                .setText(error)
                .setIcon(R.drawable.ic_warning)
                .setIconColorFilter(activity.resources.getColor(R.color.colorWhite))
                .setBackgroundColorInt(activity.resources.getColor(R.color.colorBlack))
                .show()
        }

        fun showSuccessMessage(activity: Activity, message: String) {
            hideKeyboard(activity)
            Alerter.create(activity)
                .setText(message)
                .setBackgroundColorInt(activity.getColor(R.color.colorSky))
                .show()
        }

        fun AppCompatActivity.setupToolbar(toolbar: Toolbar, textViewTitle: TextView, title: String, icon: Int, action: (View) -> Unit) {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayShowTitleEnabled(false)
            toolbar.setNavigationIcon(icon)
            textViewTitle.text = title
            textViewTitle.setTextAppearance(R.style.toolbar)
            toolbar.setNavigationOnClickListener {
                action(it)
            }
        }

        fun checkStoragePermissions(mActivity: Activity, showDialog: () -> Unit) {
            val permissions = if (Build.VERSION.SDK_INT >= 33) {
                arrayOf(Manifest.permission.READ_MEDIA_IMAGES, Manifest.permission.CAMERA)
            } else arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)

            EasyPermissions
                .with(mActivity)
                .request(
                    *permissions
                )
                .autoRetryWhenUserRefuse(
                    true
                ) { needAndCanRequestAgainPermissions ->
                    for (s in needAndCanRequestAgainPermissions) {
                        Log.e("TAG", "request again permission = $s")
                    }
                }
                .result { grantAll, results ->
                    if (grantAll) {
                        showDialog()
                    } else {
                        var appPermission = ""
                        val mediaResult = results[0]
                        val cameraResult = results[1]

                        if (mediaResult.name == Manifest.permission.READ_MEDIA_IMAGES && !mediaResult.granted) {
                            appPermission += "Media"
                        }
                        if (cameraResult.name == Manifest.permission.CAMERA && !cameraResult.granted) {
                            if (appPermission.isNotEmpty()) {
                                appPermission += " & "
                            }
                            appPermission += "Camera"
                        }

                        showSimpleAlertDialog(
                            mActivity,
                            R.drawable.ic_alert_warining,
                            "$appPermission Permission",
                            "You need to allow these permission for accessing this feature of the app",
                            "Setting"
                        ) { openAppSettings(mActivity) }
                    }
                }

        }

        private fun openAppSettings(mActivity: Activity) {
            //Utils.showToast(mActivity, "You need to allow these permission before moving ahead")
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            val uri = Uri.fromParts("package", mActivity.packageName, null)
            intent.data = uri
            mActivity.startActivity(intent)
        }


        fun showSimpleAlertDialog(
            mActivity: Activity,
            mImage: Int,
            mTitle: String,
            mDescription: String,
            mButtonName: String,
            onClick: () -> Unit
        ) {
            if (!mActivity.isFinishing) {
                AlertDialogView.showSimpleAlertDialog(
                    mActivity,
                    mImage,
                    mTitle,
                    mDescription,
                    mButtonName,
                    onClick
                )
            }
        }


        fun checkLocationPermissions(
            mActivity: Activity, permissions: Array<String>,
            loadPage: () -> Unit
        ) {
            if (!isLocationEnabled(mActivity)) {
                //showAlert()
                showSimpleAlertDialog(
                    mActivity,
                    R.drawable.image_streak,
                    "Location Service",
                    "For accessing app feature you need to enable location services",
                    "Setting"
                ) { openLocationServiceSetting(mActivity) }

            } else {

                EasyPermissions
                    .with(mActivity)
                    .request(
                        *permissions
                    )
                    .autoRetryWhenUserRefuse(
                        true
                    ) { needAndCanRequestAgainPermissions ->
                        for (s in needAndCanRequestAgainPermissions) {
                            Log.e("TAG", "request again permission = $s")
                        }
                    }
                    .result { grantAll, results ->
                        if (grantAll) {
                            loadPage()
                        } else {

                            var appPermission = ""
                            if (permissions.size == 3) {

                                val notificationResult = results[0]
                                val fineLocationResult = results[1]
                                val coarseLocationResult = results[2]

                                if (notificationResult.name == Manifest.permission.POST_NOTIFICATIONS && !notificationResult.granted) {
                                    appPermission += "Notification"
                                }
                                if ((fineLocationResult.name == Manifest.permission.ACCESS_FINE_LOCATION && !fineLocationResult.granted) || (coarseLocationResult.name == Manifest.permission.ACCESS_COARSE_LOCATION && !coarseLocationResult.granted)) {
                                    if (appPermission.isNotEmpty()) {
                                        appPermission += " & "
                                    }
                                    appPermission += "Location"
                                }
                            } else {

                                val fineLocationResult = results[0]
                                val coarseLocationResult = results[1]
                                if ((fineLocationResult.name == Manifest.permission.ACCESS_FINE_LOCATION && !fineLocationResult.granted) || (coarseLocationResult.name == Manifest.permission.ACCESS_COARSE_LOCATION && !coarseLocationResult.granted)) {
                                    appPermission += "Location"
                                }
                            }

                            showSimpleAlertDialog(
                                mActivity,
                                R.drawable.image_streak,
                                "$appPermission Permission",
                                "You need to allow these permission for accessing the feature of the app",
                                "Setting"
                            ) { openAppSettings(mActivity) }
                        }
                    }
            }


        }

        fun showDialogWithTwoButton(
            mActivity: Activity,
            icon: Int,
            title: String,
            description: String,
            buttonNo: String,
            buttonYes: String,
            onButtonNo: () -> Unit,
            onButtonYes: () -> Unit,
        ) {
            if (!mActivity.isFinishing) {
                AlertDialogView.showDialogWithTwoButton(mActivity,icon, title, description, buttonNo, buttonYes, onButtonNo, onButtonYes)
            }
        }

        fun isLocationEnabled(applicationContext: Context): Boolean {
            val locationManager =
                applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                    locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        }

        fun openLocationServiceSetting(mActivity: Activity) {
            val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            mActivity.startActivity(intent)
        }

        var networkDialogShow = false

        fun showNetworkLostAlertDialog(
            mActivity: Activity,
            mDescription: String,
            loadPage: () -> Unit
        ) {

            if (!mActivity.isFinishing) {
                if (!networkDialogShow) {
                    networkDialogShow = true
                    AlertDialogView.showNetworkLostDialog(mActivity, mDescription) { loadPage() }
                }
            }
        }






        @SuppressLint("MissingPermission")
        fun getLastKnownLocation(applicationContext: Context): Location? {
            val mLocationManager =
                applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val providers = mLocationManager.getProviders(true)
            var bestLocation: Location? = null
            for (provider in providers) {
                val l = mLocationManager.getLastKnownLocation(provider) ?: continue
                if (bestLocation == null || l.accuracy < bestLocation.accuracy) {
                    // Found best last known location: %s", l);
                    bestLocation = l
                }
            }
            return bestLocation
        }

        fun drawerOpenClose(drawerLayout: DrawerLayout) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) drawerLayout.closeDrawer(
                GravityCompat.START
            )
            else drawerLayout.openDrawer(
                GravityCompat.START
            )
        }
        fun showLoadingDialog(context: Context): ProgressDialog {
            val progressDialog = ProgressDialog(context,R.style.ProgressBar)

            progressDialog.show()
            if (progressDialog.window != null) {
                progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
            progressDialog.setContentView(R.layout.progressdialog)
            progressDialog.isIndeterminate = true

            progressDialog.setCancelable(false)
            progressDialog.setCanceledOnTouchOutside(false)


            return progressDialog
        }

        fun setupToolbar(toolbar: Toolbar, textViewTitle: TextView, title: String, icon: Int, action: (View) -> Unit) {

        }

    }



}