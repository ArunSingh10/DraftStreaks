package com.example.draftstreaks.ui.joinContest.activity.createLeagueActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceControl.Transaction
import android.widget.FrameLayout
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.draftstreaks.R
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.databinding.ActivityCreateLeagueBinding
import com.example.draftstreaks.network.NetworkUtils
import com.example.draftstreaks.ui.joinContest.activity.JoinContestActivity
import com.example.draftstreaks.ui.joinContest.fragment.createLeague.CreateLeagueFragment
import com.example.draftstreaks.utility.Utils
import com.example.draftstreaks.utility.Utils.Companion.setupToolbar

class CreateLeagueActivity : AppCompatActivity() {

     lateinit var manager: FragmentManager
     lateinit var transaction: FragmentTransaction
    var fragment: Fragment? = null
    lateinit var binding: ActivityCreateLeagueBinding
    var createLeagueScreenType = ScreenConstant.createLeague

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this,R.layout.activity_create_league)
       setupToolbar(binding.includeToolbar.toolbar, binding.includeToolbar.textViewToolbarTitle, "Create Contest", R.drawable.back_arrow) { onBackPressed() }
        checkAppPermission()
    }

    private fun checkAppPermission() {
        if (!NetworkUtils.isInternetAvailable(this)) {
            Utils.showNetworkLostAlertDialog(this@CreateLeagueActivity, "No Internet Available")
            {
                checkAppPermission()
            }
        } else {
            loadScreen()
        }
    }

    private fun loadScreen() {
        when (createLeagueScreenType) {
            ScreenConstant.createLeague -> {
                openFragment(CreateLeagueFragment(), ScreenConstant.createLeague)
            }
        }
    }


    fun openFragment(activeFragment: Fragment, tag: String) {
        manager = supportFragmentManager
        transaction = manager.beginTransaction()
        fragment = supportFragmentManager.findFragmentById(R.id.layoutCreateLeagueFrame)

        if (fragment == null){
            transaction.add(R.id.layoutCreateLeagueFrame, activeFragment, tag)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        else{
            transaction.add(R.id.layoutCreateLeagueFrame, activeFragment, tag)
            transaction.addToBackStack(null)
            transaction.commitAllowingStateLoss()
        }
    }

    override fun onRestart() {
        super.onRestart()
        checkAppPermission()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}