package com.example.draftstreaks.ui.joinContest.fragment.createLeague.createLeagueTab

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.clickInterface.OnItemClickListener
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.databinding.CustomContestBinding
import com.example.draftstreaks.ui.joinContest.activity.PrizePoolActivity
import com.example.draftstreaks.ui.joinContest.activity.createLeagueActivity.CreateLeagueActivity


class CustomContestAdapter  (var activity: CreateLeagueActivity):
    RecyclerView.Adapter<CustomContestAdapter.ViewHolder>(){

    var onClickListener: OnItemClickListener? = null

    fun setClickListener(onClickListener: OnItemClickListener) {
        this.onClickListener = onClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding  = CustomContestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var currentprogress:Int


        holder.binding.root.setOnClickListener{v->
            onClickListener!!.onClick(v,position)

        }
        holder.binding.buttonCustomJoinFee.setOnClickListener{
            activity.startActivity(Intent(activity,PrizePoolActivity::class.java))
            ScreenConstant.ScreenType = ScreenConstant.team
        }
    }

    override fun getItemCount() = 1
    inner class ViewHolder(var binding: CustomContestBinding): RecyclerView.ViewHolder(binding.root)
}