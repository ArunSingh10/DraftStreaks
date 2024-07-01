package com.example.draftstreaks.ui.joinContest.activity.Scoreboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.draftstreaks.R
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.databinding.ActivityScoreBoardBinding
import com.example.draftstreaks.databinding.ActivitySelectPlayerBinding
import com.example.draftstreaks.network.NetworkUtils
import com.example.draftstreaks.ui.joinContest.fragment.scoreBoard.ScoreBoardFragment
import com.example.draftstreaks.ui.joinContest.fragment.scoreBoard.ScoreBoardTableFragment
import com.example.draftstreaks.utility.Utils

class ScoreBoardActivity : AppCompatActivity() {
    private lateinit var manager: FragmentManager
    private lateinit var transaction: FragmentTransaction
    private var fragment: Fragment? = null
    lateinit var binding: ActivityScoreBoardBinding
    var scoreboardScreenType = ScreenConstant.scoreBoard
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_score_board)
        checkAppPermission()
    }

    fun checkAppPermission() {
        if (!NetworkUtils.isInternetAvailable(this)) {
            Utils.showNetworkLostAlertDialog(this@ScoreBoardActivity, "No Internet Available")
            {
                checkAppPermission()
            }
        } else {
            loadScreen()
        }
    }

    private fun loadScreen() {
         when(scoreboardScreenType){
             ScreenConstant.scoreBoard->{
                 openFragment(ScoreBoardFragment(),ScreenConstant.scoreBoard)
             }
             ScreenConstant.scoreBoard->{
                 openFragment(ScoreBoardTableFragment(),ScreenConstant.scoreBoardTable)
             }
         }
    }
    fun openFragment(activeFragment: Fragment, tag: String) {
        manager = supportFragmentManager
        transaction = manager.beginTransaction()
        fragment = supportFragmentManager.findFragmentByTag(tag)

        if (fragment == null)
            transaction.add(R.id.scoreboardFrameLayout, activeFragment, tag)
        else
            transaction.add(R.id.scoreboardFrameLayout, activeFragment, tag)
        transaction.addToBackStack(null)
        transaction.commitAllowingStateLoss()
    }

    override fun onRestart() {
        super.onRestart()
        checkAppPermission()
    }
}