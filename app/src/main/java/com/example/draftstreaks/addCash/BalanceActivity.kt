package com.example.draftstreaks.addCash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.ActivityAddCashBinding
import com.example.draftstreaks.databinding.ActivityBalanceBinding
import com.example.draftstreaks.utility.Utils.Companion.setupToolbar

class BalanceActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityBalanceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil. setContentView(this,R.layout.activity_balance)
        setupToolbar(binding.includeToolbar.toolbar, binding.includeToolbar.textViewToolbarTitle, "My Balance", R.drawable.back_arrow) { finish() }

        loadScreen()
    }

    private fun loadScreen() {
        binding.addWalletAmount.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.addWalletAmount->{ startActivity(Intent(this@BalanceActivity, AddCashActivity::class.java)) }
        }
    }
}