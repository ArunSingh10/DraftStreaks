package com.example.draftstreaks.ui.joinContest.activity.playerAboutActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.ActivityJoinContestBinding
import com.example.draftstreaks.databinding.ActivityPlayerInfoBinding
import com.example.draftstreaks.network.NetworkUtils
import com.example.draftstreaks.utility.Utils
import com.example.draftstreaks.utility.Utils.Companion.setupToolbar

class PlayerInfoActivity : AppCompatActivity() {
    lateinit var binding: ActivityPlayerInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_player_info)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_player_info)
        setupToolbar(binding.includeToolbar.toolbar, binding.includeToolbar.textViewToolbarTitle, "Player Name", R.drawable.back_arrow) { onBackPressed() }
    }

    fun checkAppPermission() {
        if (!NetworkUtils.isInternetAvailable(this)) {
            Utils.showNetworkLostAlertDialog(this@PlayerInfoActivity, "No Internet Available")
            {
                checkAppPermission()
            }
        } else {
            loadScreen()
        }
    }

    private fun loadScreen() {

    }
}