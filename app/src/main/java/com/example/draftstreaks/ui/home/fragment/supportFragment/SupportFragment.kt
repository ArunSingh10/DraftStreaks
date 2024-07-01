package com.example.draftstreaks.ui.home.fragment.supportFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.FragmentSupportBinding
import com.example.draftstreaks.localModel.SupportModel
import com.example.draftstreaks.localModel.getSupportModel
import com.example.draftstreaks.network.NetworkUtils
import com.example.draftstreaks.ui.home.activtiy.homeActivity.HomeActivity
import com.example.draftstreaks.utility.Utils
import com.example.draftstreaks.utility.Utils.Companion.setupToolbar

class SupportFragment : Fragment() {
    lateinit var binding: FragmentSupportBinding
    lateinit var mActivity: HomeActivity
    lateinit var support : ArrayList<SupportModel>
    lateinit var supportAdapter:SupportAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_support, container, false)
        mActivity = activity as HomeActivity
        /*  mActivity.setupToolbar(binding.includeToolbar.toolbar, binding.includeToolbar.textViewToolbarTitle, "Support", R.drawable.back_arrow) {  }*/
        checkAppPermission()
        return binding.root
    }

    private fun checkAppPermission() {
        if (!NetworkUtils.isInternetAvailable(mActivity)) {
            Utils.showNetworkLostAlertDialog(mActivity, "No Internet Available")
            {
                checkAppPermission()
            }
        } else {

            mActivity.binding.layoutCenterToolText.visibility = View.VISIBLE
            mActivity.binding.layoutToolBar.visibility = View.GONE
            mActivity.binding.toolBarProfiles.visibility = View.GONE
            mActivity.binding.parentToolBarLogo.visibility = View.VISIBLE
            mActivity.binding.parentImagebell.visibility = View.GONE
            mActivity.binding.parentImageWallets.visibility = View.GONE
            supportScreen()

        }
    }

    fun supportScreen(){

        support= getSupportModel()
        supportAdapter = SupportAdapter(mActivity,support)
        binding.recycleContestSupport.adapter=supportAdapter
        binding.recycleContestSupport.apply {
            adapter = supportAdapter
            layoutManager = LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL,false)
            setHasFixedSize(true)
        }

    }

    override fun onResume() {
        super.onResume()
        checkAppPermission()
    }


}