package com.example.draftstreaks.ui.joinContest.fragment.createLeague.createLeagueTab

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.draftstreaks.R
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.databinding.FragmentJoinLeagueBinding
import com.example.draftstreaks.ui.joinContest.activity.PrizePoolActivity
import com.example.draftstreaks.ui.joinContest.activity.createLeagueActivity.CreateLeagueActivity


class JoinLeagueFragment : Fragment(),View.OnClickListener {
lateinit var binding:FragmentJoinLeagueBinding
lateinit var mActivity:CreateLeagueActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate( inflater,R.layout.fragment_join_league, container, false)
        mActivity = activity as CreateLeagueActivity

         loadPage()
        return binding.root
    }

    private fun loadPage() {
        binding.btnJoinLeague.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
       when(p0!!.id){
           R.id.btnJoinLeague->{
            startActivity(Intent( mActivity,PrizePoolActivity::class.java))
               ScreenConstant.ScreenType  = ScreenConstant.prizePool
           }
       }
    }


}