package com.example.draftstreaks.ui.joinContest.fragment.createLeague.createLeagueTab


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.R
import com.example.draftstreaks.clickInterface.OnItemClickListener
import com.example.draftstreaks.databinding.ListRecyclerSetWinningAmountBinding
import com.example.draftstreaks.localModel.TeamModel

class SetWinningAmountAdapter

(var activity: FragmentActivity,var getCount:Int):
    RecyclerView.Adapter<SetWinningAmountAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListRecyclerSetWinningAmountBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return getCount
    }
    inner class ViewHolder(val binding: ListRecyclerSetWinningAmountBinding): RecyclerView.ViewHolder(binding.root)
}