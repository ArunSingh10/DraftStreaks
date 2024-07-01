package com.example.draftstreaks.ui.home.fragment.supportFragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.ListsupportBinding
import com.example.draftstreaks.localModel.SupportModel
import com.example.draftstreaks.ui.home.activtiy.homeActivity.HomeActivity

class SupportAdapter(
    var activity: HomeActivity,
    var supportmodel: ArrayList<SupportModel>
) : RecyclerView.Adapter<SupportAdapter.ViewHolder>() {
    var rawindex = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListsupportBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val supportmodelposition = supportmodel[position]


        holder.bindingdata.textAnswer.text = supportmodelposition.textanswer
        holder.bindingdata.textQuestion.text = supportmodelposition.textquestion
        if (position == rawindex) {
            holder.bindingdata.textAnswer.visibility = View.VISIBLE
            holder.bindingdata.imgPluse.setImageResource(R.drawable.image_minus_circle)
        } else {
            holder.bindingdata.textAnswer.visibility = View.GONE
            holder.bindingdata.imgPluse.setImageResource(R.drawable.image_plus_circle)
        }

        holder.bindingdata.root.setOnClickListener {
            rawindex = if (rawindex == position) {
                -1
            } else {
                position
            }
            notifyDataSetChanged()
        }

    }

    class ViewHolder(val bindingdata: ListsupportBinding) :
        RecyclerView.ViewHolder(bindingdata.root) {

    }

    override fun getItemCount(): Int {
        return supportmodel.size
    }


}