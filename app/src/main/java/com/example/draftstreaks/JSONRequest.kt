package com.example.draftstreaks

import com.google.gson.JsonObject

class JSONRequest {
    companion object{

        fun deleteAccount(remark: String): JsonObject {
            val jsonObjectParent = JsonObject()
            jsonObjectParent.addProperty("remark", remark)
            return jsonObjectParent
        }

        fun timeOutAccount(remark: String, timeOutDays: Int): JsonObject {
            val jsonObjectParent = JsonObject()
            jsonObjectParent.addProperty("remark", remark)
            jsonObjectParent.addProperty("time_out_days", timeOutDays)
            return jsonObjectParent
        }

        fun accessAuthentication(accessToken: String, refreshToken: String): JsonObject {
            val jsonObjectParent = JsonObject()
            jsonObjectParent.addProperty("access_token", accessToken)
            jsonObjectParent.addProperty("refresh_token", refreshToken)
            return jsonObjectParent
        }

        fun userRegister(mobile: String, referred_code: String): JsonObject {
            val jsonObjectParent = JsonObject()
            jsonObjectParent.addProperty("mobile", mobile)
            jsonObjectParent.addProperty("referred_code", referred_code)
            return jsonObjectParent
        }

        fun logIN(mobile: String): JsonObject {
            val jsonObjectParent = JsonObject()
            jsonObjectParent.addProperty("mobile", mobile)
            return jsonObjectParent
        }

        fun markPrimary(bankId: String): JsonObject {
            val jsonObjectParent = JsonObject()
            jsonObjectParent.addProperty("bank_id", bankId)
            return jsonObjectParent
        }


        fun updateProfile(
            name: String,
            email: String,
            dob: String,
            address: String,
            city: String,
            pinCode: String,
            state: String,
            gender: String,
            allowNotification: Boolean
        ): JsonObject {
            val jsonObjectParent = JsonObject()
            jsonObjectParent.addProperty("name", name)
            jsonObjectParent.addProperty("email", email)
            jsonObjectParent.addProperty("dob", dob)
            jsonObjectParent.addProperty("address", address)
            jsonObjectParent.addProperty("city", city)
            jsonObjectParent.addProperty("pin_code", pinCode)
            jsonObjectParent.addProperty("state", state)
            jsonObjectParent.addProperty("gender", gender)
            jsonObjectParent.addProperty("allow_notifications", allowNotification)
            return jsonObjectParent
        }


    }
}