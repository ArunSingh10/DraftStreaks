package com.example.draftstreaks.addCash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.ActivityAddCashBinding
import com.example.draftstreaks.utility.Utils.Companion.setupToolbar


class AddCashActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityAddCashBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding= DataBindingUtil.setContentView(this,R.layout.activity_add_cash)
      setupToolbar(binding.includeToolbar.toolbar, binding.includeToolbar.textViewToolbarTitle, "Add Cash", R.drawable.back_arrow) { finish() }

        loadScreen()
    }

    fun loadScreen(){
        binding.clearText.setOnClickListener(this)
        binding.layoutHundred.setOnClickListener(this)
        binding.layoutFiveHundred.setOnClickListener(this)
        binding.layoutThousand.setOnClickListener(this)
        binding.layoutTenThousand.setOnClickListener(this)
        binding.buttonAddCash.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.clearText ->{
                binding.editAddCash.editableText.clear()
            }
            R.id.layoutHundred ->{
                binding.editAddCash.setText(R.string.text_100)
            }
            R.id.layoutFiveHundred ->{
                binding.editAddCash.setText(R.string.text_500)
            }
            R.id.layoutThousand ->{
                binding.editAddCash.setText(R.string.text_1000)
            }
            R.id.layoutTenThousand ->{
                binding.editAddCash.setText(R.string.text_10_000)
            }
            R.id.buttonAddCash ->{
             //startActivity(Intent(this@AddCashActivity, BalanceActivity::class.java))
            }
        }
    }
}