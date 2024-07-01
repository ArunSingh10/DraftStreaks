package com.example.draftstreaks.ui.joinContest.fragment.JoinContest.tabJoinContest

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draftstreaks.R
import com.example.draftstreaks.clickInterface.OnItemClickListener
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.databinding.FragmentAllContestsBinding
import com.example.draftstreaks.ui.joinContest.activity.JoinContestActivity
import com.example.draftstreaks.ui.joinContest.activity.PrizePoolActivity
import com.example.draftstreaks.ui.joinContest.activity.Scoreboard.ScoreBoardActivity
import com.example.draftstreaks.ui.joinContest.activity.createLeagueActivity.CreateLeagueActivity
import com.example.draftstreaks.ui.joinContest.fragment.JoinContest.JoinContestFragment
import com.example.draftstreaks.ui.joinContest.fragment.JoinContest.tabJoinContest.adapter.AllContestAdapter

class AllContestsFragment : Fragment(),View.OnClickListener/* OnItemClickListener*/ {
    lateinit var binding: FragmentAllContestsBinding
    lateinit var mActivity: JoinContestActivity
    lateinit var allContestadapter: AllContestAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_all_contests, container, false)
        mActivity = activity as JoinContestActivity
        loadAllContest()
        return binding.root
    }

    fun loadAllContest() {
      binding.buttonJoinContest.setOnClickListener(this)
      binding.buttonCreateLeague.setOnClickListener(this)

        allContestadapter = AllContestAdapter(mActivity)
        binding.recyclerMegaContest.adapter = allContestadapter
        binding.recyclerMegaContest.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.recyclerMegaContest.setHasFixedSize(true)
       /* allContestadapter.setClickListener(this)*/

    }

/*    override fun onClick(view: View, position: Int) {
    startActivity(Intent(mActivity,PrizePoolActivity::class.java))
    }*/

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.buttonCreateLeague->{
                startActivity(Intent(mActivity, CreateLeagueActivity::class.java))
                ScreenConstant.tabPosition = 0
            }
            R.id.buttonJoinContest->{
                startActivity(Intent(mActivity, CreateLeagueActivity::class.java))
                ScreenConstant.tabPosition = 1

            }
        }
    }


}