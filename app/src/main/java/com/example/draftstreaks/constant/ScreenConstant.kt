package com.example.draftstreaks.constant

import android.icu.text.Transliterator.Position
import com.example.draftstreaks.localModel.ContestModel

object ScreenConstant {
    var joinContest = "joinContest"
    const val createLeague = "createLeague"
    const val pointSystem = "pointSystem"
    const val prizePool = "prizePool"

    const val scoreBoard = "ScoreBoardFragment"
    const val scoreBoardTable = "ScoreBoardTableFragment"
    var team = "TeamFragment"

    const val mockDraftFragment = "MockDraftFragment"

    var ScreenType: String? = "prizePool"
    var joinContestScreenType = "joinContest"
    var tabPosition: Int? = null
    var fromTabConfimationPosition: Int? = null

    var isEdit: String = "Yes"
    var isBasketBall = "basketball"
    var isFootball = "football"
}