package com.example.draftstreaks

import android.content.Context

import com.example.draftstreaks.constant.Constant
import com.example.draftstreaks.ui.home.DrawerModel

class AppUtils {
    companion object{

      /*  fun redirectToAddCash(mActivity : AppCompatActivity){
            mActivity.startActivity(Intent(mActivity, SabPaisaActivity::class.java))
        }*/

        fun getDrawerModel(context : Context): ArrayList<DrawerModel> {
            val drawerModel = ArrayList<DrawerModel>()

            drawerModel.add(DrawerModel(R.drawable.image_howtoplay, context.getString(R.string.text_how_to_play), "", false, ""))
            drawerModel.add(DrawerModel(R.drawable.image_fantasy_point, context.getString(R.string.text_fantasy_point), "", false, ""))
            drawerModel.add(DrawerModel(R.drawable.image_myinfo, context.getString(R.string.text_myinfo_setting), "", false, ""))
            drawerModel.add(DrawerModel(R.drawable.image_more, context.getString(R.string.text_more), "", false, ""))
            drawerModel.add(DrawerModel(R.drawable.log_out, context.getString(R.string.text_logout), "", false, ""))
          //  drawerModel.add(DrawerModel(R.drawable., context.getString(R.string.logOut), "", false, ""))

            return drawerModel
        }

        fun checkUserIsLogin(preferencesManager: PreferencesManager): Boolean {
            val fcmToken = preferencesManager.getString(Constant.fcmToken)!!
            var isLogin = preferencesManager.getBoolean(Constant.isLogin)

            if(fcmToken.isEmpty())
                isLogin = false

            return isLogin
        }
    }
}