package com.example.draftstreaks.ui.signUp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.draftstreaks.PreferencesManager
import com.example.draftstreaks.R
import com.example.draftstreaks.constant.Constant
import com.example.draftstreaks.databinding.ActivitySignUpBinding
import com.example.draftstreaks.network.NetworkUtils
import com.example.draftstreaks.ui.login.LogInActivity
import com.example.draftstreaks.ui.otpVerify.OtpVerificationActivity
import com.example.draftstreaks.ui.splash.UserGuideActivity
import com.example.draftstreaks.utility.FormValidation
import com.example.draftstreaks.utility.Utils
import javax.inject.Inject

class SignUpActivity : AppCompatActivity(),View.OnClickListener {

    lateinit var binding:ActivitySignUpBinding
    @Inject
    lateinit var preferencesManager: PreferencesManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    //    enableEdgeToEdge()
       binding =DataBindingUtil.setContentView(this,R.layout.activity_sign_up)
 /*       ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }*/
        preferencesManager = PreferencesManager(this)
loadPage()

    }

   private fun loadPage(){
        binding.layoutRedirectLogin.setOnClickListener(this)
        binding.cardBackRegister.setOnClickListener(this)
        binding.buttonContinueSignUp.setOnClickListener(this)
       editNumber()
    }

    private fun editNumber(){
        binding.editPhone.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

                if (s.length == 10) {
                    Utils.hideKeyboard(this@SignUpActivity)
                    binding.buttonContinueSignUp.isEnabled = true
                    binding.buttonContinueSignUp.alpha = 1F
                } else {
                    binding.buttonContinueSignUp.isEnabled = false
                    binding.buttonContinueSignUp.alpha = 0.5F
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
            R.id.buttonContinueSignUp -> {

                checkAppPermission()
            }

            R.id.materialCheckBox -> {

            }

            R.id.cardBackRegister -> {
                finishAffinity()
               // startActivity(Intent(this@SignUpActivity, UserGuideActivity::class.java))
            }
            R.id.layoutRedirectLogin -> {
                startActivity(Intent(this@SignUpActivity, LogInActivity::class.java))
            }

        }
    }

    fun checkAppPermission() {
        if (!NetworkUtils.isInternetAvailable(this)) {
            Utils.showNetworkLostAlertDialog(this@SignUpActivity, "No Internet Available")
            {
                checkAppPermission()
            }
        } else {
            checkValidation()
        }
    }

    @SuppressLint("SuspiciousIndentation")
    fun checkValidation() {
        val number = binding.editPhone.text!!.toString().trim()
        when (FormValidation.checkLoginValidation(number)) {
            0 -> Utils.showErrorMessage(this@SignUpActivity, getString(R.string.fieldCantBeEmpty))
            1 -> Utils.showErrorMessage(this@SignUpActivity, getString(R.string.phoneLength))
            2 -> Utils.showErrorMessage(this@SignUpActivity, getString(R.string.phoneNotValid))
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