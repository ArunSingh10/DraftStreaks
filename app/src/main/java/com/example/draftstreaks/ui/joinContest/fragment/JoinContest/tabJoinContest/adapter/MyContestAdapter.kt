package com.example.draftstreaks.ui.joinContest.fragment.JoinContest.tabJoinContest.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.ListMyContestBinding
import com.example.draftstreaks.ui.joinContest.activity.JoinContestActivity

class MyContestAdapter(
    var activity: JoinContestActivity,
) : RecyclerView.Adapter<MyContestAdapter.ViewHolder>() {

    lateinit var teamContestAdapter: SubMyContestAdapter
    var rowIndex = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyContestAdapter.ViewHolder {


        val createdView =
            ListMyContestBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(createdView)

    }

    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyContestAdapter.ViewHolder, position: Int) {

        teamContestAdapter = SubMyContestAdapter(activity)
        holder.binding.recyclerMyContest.adapter = teamContestAdapter
        holder.binding.recyclerMyContest.layoutManager = LinearLayoutManager(activity)
        holder.binding.recyclerMyContest.setHasFixedSize(true)
        //      teamContestAdapter.setclickOnListner(this)


        if (position == rowIndex) {
            holder.binding.imageViewArrows.setImageResource(R.drawable.upword_arrow_sky)
            holder.binding.recyclerMyContest.visibility = View.VISIBLE
        } else {
            holder.binding.imageViewArrows.setImageResource(R.drawable.image_dropdown)
            holder.binding.recyclerMyContest.visibility = View.GONE
        }

        holder.binding.imageViewArrows.setOnClickListener {

            rowIndex = if (rowIndex == position) {
                -1
            } else {
                position
            }
            notifyDataSetChanged()

        }


    }

    override fun getItemCount(): Int {
        return 1
    }

    inner class ViewHolder(var binding: ListMyContestBinding) :
        RecyclerView.ViewHolder(binding.root)


}