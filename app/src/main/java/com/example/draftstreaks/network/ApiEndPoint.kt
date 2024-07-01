package com.example.draftstreaks.network

import com.example.draftstreaks.appSetting.AppSetting

object ApiEndPoint {

    var LIVE_BASE_URL = AppSetting.liveBaseURL
    const val getBasicSettings = "/api/v1/get-basic-settings"
    const val getRefreshToken = "api/v1/auth/referesh-token"
    const val register = "api/v1/auth/register"
    const val verifyMobile = "api/v1/auth/verify-mobile"
    const val verifyOTP = "api/v1/auth/verify-otp"
    const val reSendOTP = "api/v1/auth/re-send-otp"
    const val removeFcmToken = "api/v1/auth/remove-fcm-token"
    const val logIn = "api/v1/auth/login"
    const val updateMobile = "api/v1/auth/update-mobile"
    const val updateProfilePic = "api/v1/update-profile-pic"
    const val fetchProfilePic = "api/v1/fetch-profile_pic"
    const val updateProfile = "api/v1/update-profile"
    const val saveName = "api/v1/save-name"
    const val getProfile = "api/v1/get-profile"
    const val banners = "api/v1/banners"

    //leagues API
    const val createTeam = "api/v1/contests/create-team"
    const val updateTeam = "api/v1/contests/update-team"
    const val addBackupPlayer = "api/v1/contests/add-backup-player"
    const val replacePlayer = "api/v1/contests/replace-player"
    const val joinLeague = "api/v1/contests/join-league"
    const val leagueById = "api/v1/contests/leagues-by-match-id/"
    const val contestWinner = "api/v1/contests/winnings/"

    // Payment API
    const val markPrimaryAccount = "api/v1/mark-primary-account"
    const val bankAccounts = "api/v1/bank-accounts"
    const val deleteBankAccounts = "api/v1/delete-bank-account"
    const val getBalance = "api/v1/transaction/get-balance"
    const val getPan = "api/v1/get-pan"
    const val deletePan = "api/v1/delete-pan"

    //AUTO KYC API
    const val addPanAuto = "api/v1/pan-kyc/verify-pan"
    const val addBankAuto = "api/v1/bank-kyc/verify-bank"
    const val addBankAutoNew = "api/v1/bank-kyc/add-bank"
    const val confirmBank = "api/v1/bank-kyc/confirm-bank"
    const val bankList = "api/v1/bank-list"
    const val createRequest = "api/v1/aadhar-kyc/create-request"
    const val verifyRequest = "api/v1/aadhar-kyc/verify-request"

    //Manual KYC API
    const val addBalanceManual = "api/v1/transaction/add-balance-m"
    const val addBankManual = "api/v1/add-bank-m"
    const val addPanManual = "api/v1/add-pan-m"
    const val addAadhaarManual = "api/v1/add-aadhar-m"
    const val getClientBankDetails = "api/v1/client-bank-details"
    const val deleteAccountV1 = "api/v1/delete-account-v1"
    const val timeoutAccount = "api/v1/timeout-account"

    //withdrawals API
    const val addWithdrawalRequest = "api/v1/add-withdrawal-request"
    const val withdrawalsRequest = "api/v1/withdrawal-requests"
    const val deleteWithdrawalRequest = "api/v1/delete-withdrawal-request"

    //Transaction API
    const val transactionContests = "api/v1/transaction/contests"
    const val transactionWithdrawals = "api/v1/transaction/withdrawals"
    const val transactionDeposits = "api/v1/transaction/deposits"
    const val transactionOther = "api/v1/transaction/others" //others
    const val transactionFilters = "api/v1/transaction/transaction-filters"
    const val transactionGenerateInvoice = "api/v1/transaction/generate-invoice"
    const val calculateCashBonus = "api/v1/transaction/calculat_cash_bonus_amount"

    //Matches API
    const val upcoming = "api/v1/match/upcoming"
    const val myUpcomingMatches = "api/v1/my-matches/upcoming"
    const val completedMatches = "api/v1/my-matches/completed"
    const val liveMatches = "api/v1/my-matches/live"
    const val recentPlayed = "api/v1/matches/recently-played"
    const val contestsFilters = "api/v1/contests/contests-filters"
    const val playerInfo = "api/v1/player/info"

    // const val playerStats = "api/v1/player/stats"
    const val playerScore = "api/v1/player/score"
    const val matchWiseFantasyStats = "api/v1/player/match-wise-fantacy-stats"

    //Profile
    const val getStats = "api/v1/get-stats"

    //Winners API
    const val megaContestWinners = "api/v1/winners/mega-contest-winners"
    const val megaContestWinnerByMatchId = "api/v1/winners/mega-contest-winners-by-match"
    const val winnerFilters = "api/v1/winners/filters"

    //PhonePay API
    const val generatePhonePayChecksum = "api/v1/phonepe/checksum"
    const val phonePayInit = "api/v1/phonepe/init"
    const val phonePayGenerateUPIIntentLink = "api/v1/phone-pay/intent/generate-link"
    const val phonePayGenerateUPIIntentCheckStatus = "api/v1/phone-pay/intent/check-status"
    const val phonePayTransactionStatus = "api/v1/phonepe/status"

    //Payment API
    const val getPaymentLink = "api/v1/upi/generat-link"
    const val checkPaymentStatus = "api/v1/rbp/payin/check-status"
    const val sabPaisaInit = "api/v1/sab-paisa/init"
    const val sabPaisaUpdateResponse = "api/v1/sab-paisa/update-response"

    //WebURL
    const val howToPlay = "how-to-play"
    const val fantasyPointSystem = "point-system"
    const val seriesLeaderBoard = "fantasy-cricket"
    const val communitiesGuidlines = "community-guidelines"
    const val jobs = "Home/ContactUs"
    const val aboutUs = "about-us"
    const val responsiblePlay = "Home/ResponsiblePlay"
    const val legality = "legality"
    const val termsCondition = "terms-and-conditions"
}