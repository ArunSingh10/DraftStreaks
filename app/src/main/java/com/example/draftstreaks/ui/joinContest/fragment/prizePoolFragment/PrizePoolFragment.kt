package com.example.draftstreaks.ui.joinContest.fragment.prizePoolFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.draftstreaks.R
import com.example.draftstreaks.constant.Constant
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.databinding.FragmentPrizePoolBinding
import com.example.draftstreaks.ui.joinContest.activity.PrizePoolActivity
import com.example.draftstreaks.ui.joinContest.fragment.teamFragment.TeamFragment
import com.example.draftstreaks.utility.Utils.Companion.setupToolbar
import com.google.android.material.tabs.TabLayout


class PrizePoolFragment : Fragment(),View.OnClickListener {

    lateinit var binding: FragmentPrizePoolBinding
    lateinit var mActivity:PrizePoolActivity
    lateinit var prizeAdapter:PrizePoolAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_prize_pool, container, false)
        mActivity = activity as PrizePoolActivity
        mActivity.setupToolbar(binding.includeToolbar.toolbar, binding.includeToolbar.textViewToolbarTitle, "Prize Pool", R.drawable.back_arrow) { mActivity.onBackPressed()}
        loadTab()
        return binding.root
    }
    private fun loadTab(){
        binding.buttonJoinFee.setOnClickListener(this)
        binding.prizePoolTabLayout.tabGravity = TabLayout.GRAVITY_FILL
        prizeAdapter = PrizePoolAdapter(childFragmentManager)
        binding.prizePoolViewPager.adapter = prizeAdapter
        binding.prizePoolTabLayout.setupWithViewPager(binding.prizePoolViewPager)

    }

    override fun onClick(p0: View?) {
       when(p0!!.id){
           R.id.buttonJoinFee->{
              ScreenConstant.ScreenType= ScreenConstant.team
               mActivity.checkAppPermission()
           }
       }
    }
}