package com.example.draftstreaks.constant

import com.example.draftstreaks.localModel.ContestModel

object Constant {
    const val REQUEST_PERMISSION_CODE_GALLERY = 101
    const val REQUEST_PERMISSION_CODE_CAMERA = 102
    const val REQUEST_PERMISSION_CODE_CROP = 103
    const val REQUEST_PERMISSION_PHONE_CALL = 104
    const val PAYMENT_PAY_REQUEST_CODE = 105
    const val REQUEST_PLAYER_SELECT = 106
    const val RESULT_LOAD_IMAGE = 1

    const val isLogin="isLogin"
    var logout = "logout"
    const val isSliderShown="isSliderShown"
    const val accessToken="accessToken"
    const val refreshToken="refreshToken"
    const val fcmToken="fcmToken"
    const val uniqueDeviceId="uniqueDeviceId"
    const val referredCode="referredCode"


    val createSameView:ArrayList<ContestModel>? = null
}