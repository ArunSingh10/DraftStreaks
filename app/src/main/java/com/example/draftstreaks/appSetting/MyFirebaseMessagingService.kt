package com.example.draftstreaks.appSetting

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.draftstreaks.R
import com.example.draftstreaks.ui.splash.SplashActivity
import com.example.draftstreaks.utility.Utils
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


@SuppressLint("MissingFirebaseInstanceTokenRefresh")
class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        if (remoteMessage.data.isNotEmpty()) {
            try {
                val data = remoteMessage.data
                val title = data["title"]
                val body = data["body"]
                Log.e("notification", "title: $title")
                Log.e("notification", "body: $body")

             /*   showLineupNotification(title, body)*/
            } catch (e: Exception) {
                Log.e("TAG", "Exception: " + e.message)
            }
        } else if (remoteMessage.notification != null) {


            val notificationData = remoteMessage.notification!!

            showNotification(notificationData)

        }
    }

/*    @SuppressLint("WrongConstant")
    private fun showLineupNotification(notificationTitle: String?, notificationMessage: String?) {
        try {
            val requestID = System.currentTimeMillis().toInt()

            val intent = Intent(this, SplashScreenActivity::class.java)

            val channelId = "notification_channel"

            var pendingIntent: PendingIntent? = null
            pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_MUTABLE)
            } else {
                PendingIntent.getActivity(
                    this,
                    0,
                    intent,
                    PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
                )
            }

            val builder: NotificationCompat.Builder =
                NotificationCompat.Builder(applicationContext, channelId)
                    .setSmallIcon(R.drawable.ic_notification_app_icon)
                    .setAutoCancel(true)
                    .setVibrate(longArrayOf(1000, 1000, 1000, 1000))
                    .setOnlyAlertOnce(true)
                    .setContentIntent(pendingIntent)
                    .setContentTitle(notificationTitle)
                    .setContentText(notificationMessage)
            //.setSmallIcon(R.mipmap.ic_launcher)

            builder.color = resources.getColor(R.color.colorPrimaryDark)

            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notificationChannel = NotificationChannel(
                    channelId, getString(R.string.app_name) + "App",
                    NotificationManager.IMPORTANCE_HIGH
                )
                notificationManager.createNotificationChannel(notificationChannel)
            }

            notificationManager.notify(0, builder.build())
        }
        catch (e: Exception){
            Log.e("notificationBuilder", "Exception: " + e.message)
        }
    }*/

    @SuppressLint("ObsoleteSdkInt", "WrongConstant")
    private fun showNotification(notificationData: RemoteMessage.Notification) {
        try {
            Log.d("notification", notificationData.toString())

            val notificationTitle = notificationData.title
            val notificationMessage = notificationData.body
            val notificationImageURL = notificationData.imageUrl


            val requestID = System.currentTimeMillis().toInt()

            val intent = Intent(this, SplashActivity::class.java)

            val channelId = "notification_channel"

            var pendingIntent: PendingIntent? = null
            pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_MUTABLE)
            } else {
                PendingIntent.getActivity(
                    this,
                    0,
                    intent,
                    PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
                )
            }

            val builder: NotificationCompat.Builder =
                NotificationCompat.Builder(applicationContext, channelId)
                    .setSmallIcon(R.drawable.image_streak)
                    .setAutoCancel(true)
                    .setVibrate(longArrayOf(1000, 1000, 1000, 1000))
                    .setOnlyAlertOnce(true)
                    .setContentIntent(pendingIntent)
                    .setContentTitle(notificationTitle)
                    .setContentText(notificationMessage)
            //.setSmallIcon(R.mipmap.ic_launcher)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder.color = resources.getColor(R.color.colorPrimaryDark)
            }

            if (notificationImageURL != null) {
                val bitmap: Bitmap? = Utils.getBitmapFromUrl(notificationData.imageUrl.toString())
                builder.setStyle(
                    NotificationCompat.BigPictureStyle()
                        .bigPicture(bitmap)
                    //.bigLargeIcon(null)
                ).setLargeIcon(bitmap)
            }

            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notificationChannel = NotificationChannel(
                    channelId, getString(R.string.app_name) + "App",
                    NotificationManager.IMPORTANCE_HIGH
                )
                notificationManager.createNotificationChannel(notificationChannel)
            }

            notificationManager.notify(0, builder.build())
        }
        catch (e : Exception){
            Log.e("notificationBuilder", "Exception: " + e.message)
        }


    }

}