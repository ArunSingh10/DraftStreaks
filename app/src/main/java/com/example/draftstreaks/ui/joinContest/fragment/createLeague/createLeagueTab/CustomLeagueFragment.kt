package com.example.draftstreaks.ui.joinContest.fragment.createLeague.createLeagueTab

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draftstreaks.R
import com.example.draftstreaks.clickInterface.OnItemClickListener
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.databinding.BigBoardBoxBinding
import com.example.draftstreaks.databinding.FragmentCustomLeagueBinding
import com.example.draftstreaks.ui.joinContest.activity.PrizePoolActivity
import com.example.draftstreaks.ui.joinContest.activity.createLeagueActivity.CreateLeagueActivity
import com.example.draftstreaks.ui.joinContest.fragment.selectPlayer.GridBigBoardAdapter


class CustomLeagueFragment : Fragment(),View.OnClickListener, OnItemClickListener {
    lateinit var binding: FragmentCustomLeagueBinding
    lateinit var mActivity: CreateLeagueActivity
    lateinit var setWinningAdapter: SetWinningAmountAdapter
    lateinit var customAdapter: CustomContestAdapter
    lateinit var addButton:TextView
    var addCount = 3

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_custom_league, container, false)
        mActivity = activity as CreateLeagueActivity
        binding.buttonCreateContest.setOnClickListener(this)

        setUp()
        return binding.root
    }

    fun setUp() {
        setWinningAdapter = SetWinningAmountAdapter(mActivity,addCount)
        binding.contenierRecycler.adapter = setWinningAdapter
        binding.contenierRecycler.layoutManager =LinearLayoutManager(mActivity,LinearLayoutManager.VERTICAL,false)
        binding.contenierRecycler.setHasFixedSize(true)
        addMoreWinning()
    }
    fun addMoreWinning(){
        addButton = binding.addAmount
        addButton.setOnClickListener{ addCount++
            setUp()
        }
    }

    override fun onClick(p0: View?) {
       when(p0!!.id){
           R.id.buttonCreateContest->{
               binding.nestedScroll.visibility=View.GONE
               binding.addAmount.visibility=View.GONE
               binding.buttonCreateContest.visibility=View.VISIBLE
               binding.customContestRecycler.visibility =View.VISIBLE
               binding.listOfYour.visibility =View.VISIBLE
               customAdapter = CustomContestAdapter(mActivity)
               binding.customContestRecycler.adapter = customAdapter
                   binding.customContestRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
               binding.customContestRecycler.setHasFixedSize(true)
               customAdapter.setClickListener(this)

           }
       }
    }

    override fun onClick(view: View, position: Int) {
     startActivity(Intent(mActivity,PrizePoolActivity::class.java))
        ScreenConstant.ScreenType  = ScreenConstant.prizePool
    }



}