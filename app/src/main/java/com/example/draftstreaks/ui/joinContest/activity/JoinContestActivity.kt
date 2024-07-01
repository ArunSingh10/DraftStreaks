package com.example.draftstreaks.ui.joinContest.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.draftstreaks.R
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.constant.ScreenConstant.joinContestScreenType
import com.example.draftstreaks.databinding.ActivityJoinContestBinding
import com.example.draftstreaks.network.NetworkUtils
import com.example.draftstreaks.ui.home.activtiy.homeActivity.HomeActivity
import com.example.draftstreaks.ui.home.fragment.homeFragment.HomeFragment
import com.example.draftstreaks.ui.joinContest.activity.createLeagueActivity.CreateLeagueActivity
import com.example.draftstreaks.ui.joinContest.fragment.JoinContest.JoinContestFragment
import com.example.draftstreaks.ui.joinContest.fragment.createLeague.CreateLeagueFragment
import com.example.draftstreaks.utility.Utils
import com.example.draftstreaks.utility.Utils.Companion.setupToolbar

class JoinContestActivity : AppCompatActivity(){
    private lateinit var manager: FragmentManager
    private lateinit var transaction: FragmentTransaction
    private var fragment: Fragment? = null
    lateinit var binding:ActivityJoinContestBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding=DataBindingUtil.setContentView(this,R.layout.activity_join_contest)
      setupToolbar(binding.includeToolbar.toolbar, binding.includeToolbar.textViewToolbarTitle, "Contest", R.drawable.back_arrow) { onBackPressed() }
       checkAppPermission()
    }


    fun checkAppPermission() {
        if (!NetworkUtils.isInternetAvailable(this)) {
            Utils.showNetworkLostAlertDialog(this@JoinContestActivity, "No Internet Available")
            {
                checkAppPermission()
            }
        } else {

            loadScreen()
        }
     }
    fun loadScreen() {


        when (joinContestScreenType) {
            ScreenConstant.joinContest -> {
                openFragment(JoinContestFragment(), ScreenConstant.joinContest)
            }
        }
    }
   fun openFragment(activeFragment: Fragment, tag: String) {
        manager = supportFragmentManager
        transaction = manager.beginTransaction()
        fragment = supportFragmentManager.findFragmentByTag(tag)

        if (fragment == null)
            transaction.add(R.id.layoutContestFrame, activeFragment, tag)
        else
            transaction.add(R.id.layoutContestFrame, activeFragment, tag)
        transaction.addToBackStack(null)
        transaction.commitAllowingStateLoss()
    }


    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
         this.finish()
    }


    override fun onRestart() {
        super.onRestart()
        checkAppPermission()
    }
}