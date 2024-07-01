package com.example.draftstreaks.utility

import android.text.TextUtils
import android.util.Patterns

class FormValidation {
    companion object{
/*

        private fun isValidEmail(email: String): Boolean {
            val pattern = Patterns.EMAIL_ADDRESS
            return pattern.matcher(email).matches()
        }

        private fun isValidPassword(password: String?) : Boolean {
            password?.let {
                val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"
                val passwordMatcher = Regex(passwordPattern)

                return passwordMatcher.find(password) != null
            } ?: return false
        }
*/

        private fun isValidPhoneNumber(phone:String?) : Boolean {
            phone?.let {
                val phonPattern = "^(?:(?:\\+|0{0,2})91(\\s*|[\\-])?|[0]?)?([6789]\\d{2}([ -]?)\\d{3}([ -]?)\\d{4})\$"
                val passwordMatcher = Regex(phonPattern)
                return passwordMatcher.find(phone) != null
            } ?: return false
        }

        private fun isphonelength(phoneNumber:String?): Boolean {

            return if(phoneNumber!!.length!=10){
                true
            }else{
                false
            }

        }
        private fun isOtplength(otp:String?): Boolean {

            return if(otp!!.length!=6){
                true
            }else{
                false
            }

        }

        fun checkLoginValidation(phoneNumber:String): Int {
            return if (TextUtils.isEmpty(phoneNumber))
                0
            else if (isphonelength(phoneNumber))
                1
            else if (!isValidPhoneNumber(phoneNumber))
               2
            else
                -1
        }

        fun otpValidation(otp:String):Int{
            return if (TextUtils.isEmpty(otp))
                0
            else if (isOtplength(otp))
                1
            else
                -1
        }
    }
}