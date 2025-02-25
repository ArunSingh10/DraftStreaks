package com.example.draftstreaks.appSetting

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.draftstreaks.clickInterface.SmsBroadcastReceiverListener
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.common.api.Status

class SmsBroadcastReceiver : BroadcastReceiver() {

    var smsBroadcastReceiverListener: SmsBroadcastReceiverListener? = null

    override fun onReceive(context: Context, intent: Intent) {

        if (intent.action === SmsRetriever.SMS_RETRIEVED_ACTION) {
            val extras = intent.extras
            val smsRetrieverStatus = extras!![SmsRetriever.EXTRA_STATUS] as Status?
            when (smsRetrieverStatus!!.statusCode) {
                CommonStatusCodes.SUCCESS -> {
                    val messageIntent = extras.getParcelable<Intent>(SmsRetriever.EXTRA_CONSENT_INTENT)
                    if(smsBroadcastReceiverListener != null) {
                        smsBroadcastReceiverListener!!.onSuccess(messageIntent)
                    }
                }

                CommonStatusCodes.TIMEOUT -> if(smsBroadcastReceiverListener != null) {
                    smsBroadcastReceiverListener!!.onFailure()
                }
            }
        }
    }


}