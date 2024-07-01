package com.example.draftstreaks.ui.home.fragment.MockDraftFragment.mockDraftTab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.FragmentWinningsDraftBinding
import com.example.draftstreaks.ui.home.activtiy.mockDraftActivity.MockDratfActivity
import com.example.draftstreaks.ui.joinContest.fragment.prizePoolFragment.prizePoolTab.WinningAdapter

class WinningsDraftFragment : Fragment() {
    lateinit var binding: FragmentWinningsDraftBinding
    lateinit var mActivity: MockDratfActivity
    lateinit var  winningsAdapter: WinningAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_winnings_draft, container, false)


        mActivity = activity as MockDratfActivity

        loadScreen()
        return binding.root
    }

    private fun loadScreen() {

        winningsAdapter = WinningAdapter(mActivity)
        binding.winDraftRecycler.adapter = winningsAdapter
        binding.winDraftRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.winDraftRecycler.setHasFixedSize(true)
    }


}