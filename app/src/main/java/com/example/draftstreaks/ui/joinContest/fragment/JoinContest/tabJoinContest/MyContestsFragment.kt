package com.example.draftstreaks.ui.joinContest.fragment.JoinContest.tabJoinContest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.FragmentMyContestsBinding
import com.example.draftstreaks.ui.joinContest.activity.JoinContestActivity
import com.example.draftstreaks.ui.joinContest.fragment.JoinContest.JoinContestFragment
import com.example.draftstreaks.ui.joinContest.fragment.JoinContest.tabJoinContest.adapter.MyContestAdapter

class MyContestsFragment() : Fragment() {

    lateinit var binding:FragmentMyContestsBinding
    lateinit var mActivity:JoinContestActivity
    lateinit var adapter:MyContestAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_contests, container, false)
       mActivity = activity as JoinContestActivity
        loadMyContest()
        return binding.root
    }

    private fun loadMyContest() {

        adapter = MyContestAdapter(mActivity)
        binding.myContestRecycler.adapter = adapter
        binding.myContestRecycler.layoutManager = LinearLayoutManager(mActivity,LinearLayoutManager.VERTICAL,false)
        binding.myContestRecycler.setHasFixedSize(true)

    }

}