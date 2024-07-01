package com.example.draftstreaks.ui.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.draftstreaks.PreferencesManager
import com.example.draftstreaks.R
import com.example.draftstreaks.constant.Constant
import com.example.draftstreaks.databinding.ActivityLogInBinding
import com.example.draftstreaks.network.NetworkUtils
import com.example.draftstreaks.ui.otpVerify.OtpVerificationActivity
import com.example.draftstreaks.ui.signUp.SignUpActivity
import com.example.draftstreaks.ui.splash.UserGuideActivity
import com.example.draftstreaks.utility.FormValidation
import com.example.draftstreaks.utility.Utils
import com.example.draftstreaks.utility.Utils.Companion.hideKeyboard
import com.example.draftstreaks.utility.Utils.Companion.showErrorMessage
import com.google.android.material.internal.ViewUtils.hideKeyboard
import javax.inject.Inject


class LogInActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityLogInBinding
    @Inject
    lateinit var preferencesManager: PreferencesManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@LogInActivity, R.layout.activity_log_in)

        preferencesManager = PreferencesManager(this)
        loadPage()
    }

    private fun loadPage() {
        binding.cardBackLayout.setOnClickListener(this)
        binding.buttonContinue.setOnClickListener(this)
        binding.materialCheckBox.setOnClickListener(this)
        binding.layoutRedirectRegister.setOnClickListener(this)
        editNumber()
    }
  private fun editNumber(){
       binding.editPhoneNumber.addTextChangedListener(object : TextWatcher {

           override fun afterTextChanged(s: Editable) {

               if (s.length == 10) {
                   hideKeyboard(this@LogInActivity)
                   binding.buttonContinue.isEnabled = true
                   binding.buttonContinue.alpha = 1F
               } else {
                   binding.buttonContinue.isEnabled = false
                   binding.buttonContinue.alpha = 0.5F
               }
           }

           override fun beforeTextChanged(
               s: CharSequence, start: Int,
               count: Int, after: Int
           ) {
           }

           override fun onTextChanged(
               s: CharSequence, start: Int,
               before: Int, count: Int
           ) {
           }
       })
   }
    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.buttonContinue -> {
                checkAppPermission()
            }

            R.id.materialCheckBox -> {

            }

            R.id.cardBackLayout -> {
                startActivity(Intent(this@LogInActivity, SignUpActivity::class.java))
            }
            R.id.layoutRedirectRegister -> {
                startActivity(Intent(this@LogInActivity, SignUpActivity::class.java))
            }

        }
    }


    fun checkAppPermission() {
        if (!NetworkUtils.isInternetAvailable(this)) {
            Utils.showNetworkLostAlertDialog(this@LogInActivity, "No Internet Available")
            {
                checkAppPermission()
            }
        } else {
            checkValidation()
        }
    }

    @SuppressLint("SuspiciousIndentation")
    fun checkValidation() {
        val number = binding.editPhoneNumber.text!!.toString().trim()
        when (FormValidation.checkLoginValidation(number)) {

            0 -> showErrorMessage(this@LogInActivity, getString(R.string.fieldCantBeEmpty))
            1 -> showErrorMessage(this@LogInActivity, getString(R.string.phoneLength))
            2 -> showErrorMessage(this@LogInActivity, getString(R.string.phoneNotValid))
            -1 ->{
                preferencesManager.setBoolean(Constant.isLogin,true)
                startActivity(Intent(this, OtpVerificationActivity::class.java))
            }
        }
    }

    override fun onResume() {
        super.onResume()
        loadPage()
    }
}