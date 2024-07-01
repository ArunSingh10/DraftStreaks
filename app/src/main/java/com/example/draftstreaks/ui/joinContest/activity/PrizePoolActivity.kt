package com.example.draftstreaks.ui.joinContest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.draftstreaks.R
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.databinding.ActivityPrizePoolBinding
import com.example.draftstreaks.network.NetworkUtils
import com.example.draftstreaks.ui.joinContest.fragment.prizePoolFragment.PrizePoolFragment
import com.example.draftstreaks.ui.joinContest.fragment.teamFragment.TeamFragment
import com.example.draftstreaks.utility.Utils

class PrizePoolActivity : AppCompatActivity() {
    lateinit var binding:ActivityPrizePoolBinding

    private lateinit var manager: FragmentManager
    private lateinit var transaction: FragmentTransaction
    private var fragment: Fragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this,R.layout.activity_prize_pool)
        checkAppPermission()
    }
      fun checkAppPermission() {
        if (!NetworkUtils.isInternetAvailable(this)) {
            Utils.showNetworkLostAlertDialog(this@PrizePoolActivity, "No Internet Available")
            {
                checkAppPermission()
            }
        } else {
            when(ScreenConstant.ScreenType){
                ScreenConstant.prizePool->{
                    openFragment(PrizePoolFragment(),ScreenConstant.prizePool)
                }
                ScreenConstant.team->{
                    openFragment(TeamFragment(),ScreenConstant.team)
                }
            }

        }
    }

    fun openFragment(activeFragment: Fragment, tag: String) {
        manager = supportFragmentManager
        transaction = manager.beginTransaction()
        fragment = supportFragmentManager.findFragmentByTag(tag)

        if (fragment == null)
            transaction.add(R.id.layoutPrizePoolFrame, activeFragment, tag)
        else
            transaction.add(R.id.layoutPrizePoolFrame, activeFragment, tag)
        transaction.addToBackStack(null)
        transaction.commitAllowingStateLoss()
    }

    override fun onBackPressed() {
        super.onBackPressed()
       finish()
    }

    override fun onRestart() {
        super.onRestart()
        checkAppPermission()
    }

/*    override fun onResume() {
        super.onResume()
        checkAppPermission()
    }*/

}