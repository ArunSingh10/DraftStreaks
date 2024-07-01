package com.example.draftstreaks.ui.joinContest.fragment.JoinContest.tabJoinContest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.FragmentMyDraftBinding
import com.example.draftstreaks.ui.joinContest.activity.JoinContestActivity
import com.example.draftstreaks.ui.joinContest.fragment.JoinContest.JoinContestFragment
import com.example.draftstreaks.ui.joinContest.fragment.JoinContest.tabJoinContest.adapter.MyDraftAdapter


class MyDraftFragment: Fragment() {

    lateinit var binding: FragmentMyDraftBinding
    lateinit var mActivity: JoinContestActivity
    lateinit var adapter: MyDraftAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View{
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_draft, container, false)
        mActivity = activity as JoinContestActivity

        loadMyDraft()

        return binding.root
    }

    private fun loadMyDraft() {

        adapter = MyDraftAdapter(mActivity)
        binding.myDraftRecycler.adapter = adapter
        binding.myDraftRecycler.layoutManager = LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL,false)

        binding.myDraftRecycler.setHasFixedSize(true)
    }


}