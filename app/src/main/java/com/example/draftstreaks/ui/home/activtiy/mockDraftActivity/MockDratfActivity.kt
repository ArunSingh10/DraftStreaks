package com.example.draftstreaks.ui.home.activtiy.mockDraftActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.draftstreaks.R
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.databinding.ActivityMockDraftBinding
import com.example.draftstreaks.network.NetworkUtils
import com.example.draftstreaks.ui.home.fragment.MockDraftFragment.MockDraftFragment
import com.example.draftstreaks.utility.Utils

class MockDratfActivity : AppCompatActivity() {

    private lateinit var manager: FragmentManager
    private lateinit var transaction: FragmentTransaction
    private var fragment: Fragment? = null
    lateinit var binding: ActivityMockDraftBinding
    var joinContestScreenType = ScreenConstant.mockDraftFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this,R.layout.activity_mock_draft)
        checkAppPermission()
    }

    private fun checkAppPermission() {
        if (!NetworkUtils.isInternetAvailable(this)) {
            Utils.showNetworkLostAlertDialog(this@MockDratfActivity, "No Internet Available")
            {
                checkAppPermission()
            }
        } else {
            loadScreen()
        }
    }

    fun loadScreen() {

        when (joinContestScreenType) {
            ScreenConstant.mockDraftFragment -> {
                openFragment(MockDraftFragment(), ScreenConstant.mockDraftFragment)
            }
        }
    }

    fun openFragment(activeFragment: Fragment, tag: String) {
        manager = supportFragmentManager
        transaction = manager.beginTransaction()
        fragment = supportFragmentManager.findFragmentByTag(tag)

        if (fragment == null)
            transaction.add(R.id.completedDraftFrame, activeFragment, tag)
        else
            transaction.add(R.id.completedDraftFrame, activeFragment, tag)
        transaction.addToBackStack(null)
        transaction.commitAllowingStateLoss()
    }
}