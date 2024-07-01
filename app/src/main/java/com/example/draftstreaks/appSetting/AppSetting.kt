package com.example.draftstreaks.appSetting

object AppSetting{

    const val productionBaseURL = "https://www.jackpot-11.com/"

    var liveBaseURL =  productionBaseURL

    //   if (BuildConfig.DEBUG) productionBaseURL else productionBaseURL

    const val userNameMandatory = true
    const val isSportListShown = false
    const val isKycMandatory = false
    const val isBackupAllow = false
    const val isReferral = false
    const val matchListPageDataSize = 5
    const val leaguesByMatchIdPageDataSize = 10
    const val transactionPageDataSize = 20
    const val userLeaderBoardPageDataSize = 100
    const val referralBonus = 10
    const val referredAmount = 5
}