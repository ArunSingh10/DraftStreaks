package com.example.draftstreaks.ui.otpVerify

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.ActivityOtpVerificationBinding
import com.example.draftstreaks.network.NetworkUtils
import com.example.draftstreaks.ui.userName.UserNameActivity
import com.example.draftstreaks.utility.FormValidation
import com.example.draftstreaks.utility.Utils

class OtpVerificationActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var binding:ActivityOtpVerificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this@OtpVerificationActivity,R.layout.activity_otp_verification)


        loadPage()
    }

    private fun loadPage() {
        binding.buttonOtpSubmit.setOnClickListener(this)

        binding.editOtp1.addTextChangedListener(GenricTextWatcher(binding.editOtp1,binding.editOtp2))
        binding.editOtp2.addTextChangedListener(GenricTextWatcher(binding.editOtp2,binding.editOtp3))
        binding.editOtp3.addTextChangedListener(GenricTextWatcher(binding.editOtp3,binding.editOtp4))
        binding.editOtp4.addTextChangedListener(GenricTextWatcher(binding.editOtp4,binding.editOtp5))
        binding.editOtp5.addTextChangedListener(GenricTextWatcher(binding.editOtp5,binding.editOtp6))
        binding.editOtp6.addTextChangedListener(GenricTextWatcher(binding.editOtp6,null))

        binding.editOtp1.setOnKeyListener(GenricKeyEvent(binding.editOtp1,null))
        binding.editOtp2.setOnKeyListener(GenricKeyEvent(binding.editOtp2,binding.editOtp1))
        binding.editOtp3.setOnKeyListener(GenricKeyEvent(binding.editOtp3,binding.editOtp2))
        binding.editOtp4.setOnKeyListener(GenricKeyEvent(binding.editOtp4,binding.editOtp3))
        binding.editOtp5.setOnKeyListener(GenricKeyEvent(binding.editOtp5,binding.editOtp4))
        binding.editOtp6.setOnKeyListener(GenricKeyEvent(binding.editOtp6,binding.editOtp5))
    }
    inner class GenricTextWatcher internal constructor(val currentView: View, val nextView: View?) :
        TextWatcher {
        @SuppressLint("UseCompatLoadingForDrawables", "ResourceType")
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        @SuppressLint("ResourceAsColor")
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            when (currentView.id) {

                R.id.editOtp1->{
                    binding.editOtp1.setBackgroundResource(R.drawable.stroke_with_otp_bg)
                }

                R.id.editOtp2->{
                    binding.editOtp2.setBackgroundResource(R.drawable.stroke_with_otp_bg)
                }
                R.id.editOtp3-> {
                    binding.editOtp3.setBackgroundResource(R.drawable.stroke_with_otp_bg)
                }
                R.id.editOtp4->{
                    binding.editOtp4.setBackgroundResource(R.drawable.stroke_with_otp_bg)
                }
                R.id.editOtp5->{
                    binding.editOtp5.setBackgroundResource(R.drawable.stroke_with_otp_bg)
                }
                R.id.editOtp6->{
                    binding.editOtp6.setBackgroundResource(R.drawable.stroke_with_otp_bg)
                }
            }
            //    currentView.setBackgroundColor(resources.getColor(R.color.Themecolor))
        }

        override fun afterTextChanged(editable: Editable?) {
            val text = editable.toString()

            when (currentView.id) {

                R.id.editOtp1->{

                    if(text.length==1) nextView!!.requestFocus()
                }
                R.id.editOtp2->{

                    if(text.length==1) nextView!!.requestFocus()
                }
                R.id.editOtp3-> {

                    if(text.length==1) nextView!!.requestFocus()
                }
                R.id.editOtp4->{

                    if(text.length==1) nextView!!.requestFocus()
                }
                R.id.editOtp5->{

                    if(text.length==1) nextView!!.requestFocus()
                }
            }

        }

    }
    inner class GenricKeyEvent internal constructor(val currentView: EditText?, val priviousView:EditText?):View.OnKeyListener{
        override fun onKey(p0: View?, keyCode: Int, event: KeyEvent?): Boolean {
            if(event!!.action== KeyEvent.ACTION_DOWN && keyCode==KeyEvent.KEYCODE_DEL && currentView!!.id != R.id.editOtp1 && currentView.text.isEmpty()){

                priviousView!!.text=null
                when (currentView.id) {

                    R.id.editOtp1->{
                        binding.editOtp1.setBackgroundResource(R.drawable.normal_otp_bg)
                    }
                    R.id.editOtp2->{
                        binding.editOtp2.setBackgroundResource(R.drawable.normal_otp_bg)
                    }
                    R.id.editOtp3-> {
                        binding.editOtp3.setBackgroundResource(R.drawable.normal_otp_bg)
                    }
                    R.id.editOtp4->{
                        binding.editOtp4.setBackgroundResource(R.drawable.normal_otp_bg)
                    }
                    R.id.editOtp5->{
                        binding.editOtp5.setBackgroundResource(R.drawable.normal_otp_bg)
                    }
                    R.id.editOtp6->{
                        binding.editOtp6.setBackgroundResource(R.drawable.normal_otp_bg)
                    }
                }
                priviousView.requestFocus()
                return true
            }
            return false

        }

    }

    override fun onClick(p0: View?) {
      when(p0!!.id){
          R.id.buttonOtpSubmit->{
              checkAppPermission()
          }
      }
    }

    fun checkAppPermission() {
        if (!NetworkUtils.isInternetAvailable(this)) {
            Utils.showNetworkLostAlertDialog(this@OtpVerificationActivity, "No Internet Available")
            {
                checkAppPermission()
            }
        } else {
            checkValidation()
        }
    }
    @SuppressLint("SuspiciousIndentation")
    fun checkValidation() {
        val otp=96360
        val allOtp = binding.editOtp1.text!!.toString().trim()+
                           binding.editOtp2.text!!.toString().trim()+
                           binding.editOtp3.text!!.toString().trim()+
                           binding.editOtp4.text!!.toString().trim()+
                           binding.editOtp5.text!!.toString().trim()+
                           binding.editOtp6.text!!.toString().trim()


        when (FormValidation.otpValidation(allOtp)) {
            0 -> Utils.showErrorMessage(this@OtpVerificationActivity, getString(R.string.fieldCantBeEmpty))
            1 -> Utils.showErrorMessage(this@OtpVerificationActivity, getString(R.string.otpLength))
            -1 ->
                startActivity(Intent(this, UserNameActivity::class.java))
        }
    }
}