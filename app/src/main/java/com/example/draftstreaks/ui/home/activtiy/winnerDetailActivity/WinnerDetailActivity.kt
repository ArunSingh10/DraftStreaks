package com.example.draftstreaks.ui.home.activtiy.winnerDetailActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.ActivityWinnerDetailBinding
import com.example.draftstreaks.ui.home.activtiy.winnerDetailActivity.adapter.WinnerDetailAdapter
import com.example.draftstreaks.utility.Utils
import com.example.draftstreaks.utility.Utils.Companion.setupToolbar

class WinnerDetailActivity : AppCompatActivity() {
    lateinit var binding:ActivityWinnerDetailBinding
    lateinit var adapter:WinnerDetailAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_winner_detail)
        setupToolbar(binding.toolBarWinnerDetailActivity.toolbar, binding.toolBarWinnerDetailActivity.textViewToolbarTitle, "Winner  Profile", R.drawable.back_arrow) { onBackPressed() }
        loadPage()
    }

    private fun loadPage() {

        adapter = WinnerDetailAdapter(this)
        binding.recyclerWinnerDetail.adapter = adapter
        binding.recyclerWinnerDetail.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.recyclerWinnerDetail.setHasFixedSize(true)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }


}