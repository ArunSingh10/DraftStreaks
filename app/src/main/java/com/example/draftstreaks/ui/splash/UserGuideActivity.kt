package com.example.draftstreaks.ui.splash

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.ActivityUserGuideBinding
import com.example.draftstreaks.localModel.SliderModel
import com.example.draftstreaks.localModel.getSliderModel
import com.example.draftstreaks.ui.login.LogInActivity
import com.example.draftstreaks.ui.signUp.SignUpActivity
import com.example.draftstreaks.utility.Utils

class UserGuideActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityUserGuideBinding
    lateinit var sliderAdapter: UserSliderAdapter
    private var sliderModel = ArrayList<SliderModel>()
    private lateinit var dialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_guide)
        dialog = Utils.showLoadingDialog(this)
        dialog.show()
        Handler(Looper.getMainLooper()).postDelayed({
            loadPage()
        }, 500)

    }

    fun loadPage() {
        binding.laoutSkip.setOnClickListener(this)


        dialog.dismiss()
        binding.buttonUserSlider.setOnClickListener(this)
        sliderModel = getSliderModel()
        sliderAdapter = UserSliderAdapter(this)
        sliderAdapter.sliderModel = sliderModel
        binding.viewPagerUserSlider.adapter = sliderAdapter
        binding.viewPagerUserSlider.currentItem = 0
        binding.tabLayout.setupWithViewPager(binding.viewPagerUserSlider, true)

    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.buttonUserSlider -> {
                startActivity(Intent(this, SignUpActivity::class.java))
            }
            R.id.laoutSkip -> {
                startActivity(Intent(this, SignUpActivity::class.java))
            }
        }
    }
}