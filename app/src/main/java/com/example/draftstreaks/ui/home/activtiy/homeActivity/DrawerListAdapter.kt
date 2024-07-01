package com.example.draftstreaks.ui.home.activtiy.homeActivity

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.DrawerListBinding
import com.example.draftstreaks.ui.home.DrawerModel
import com.example.draftstreaks.utility.Utils
import com.example.draftstreaks.utility.Utils.Companion.showErrorMessage

class DrawerListAdapter(
    val activity: HomeActivity
) : RecyclerView.Adapter<DrawerListAdapter.ViewHolder>() {
    lateinit var drawerModel: ArrayList<DrawerModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding  = DrawerListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }



    @SuppressLint("SetTextI18n", "ResourceType")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val drawer = drawerModel[position]

        holder.binding.itemText.text = drawer.itemName
        holder.binding.itemIcons.setImageResource(drawer.itemIcon!!)
        holder.binding.itemText.setOnClickListener {
            onItemClick(drawer.itemName)
        }

    }

    override fun getItemCount(): Int {
        return drawerModel.size
    }

    inner class ViewHolder(val binding: DrawerListBinding) : RecyclerView.ViewHolder(binding.root)


    private fun onItemClick(name : String?){
        when (name) {
            // activity.getString(R.string.myBalance) -> activity.startActivity(Intent(activity, AddCashActivity::class.java).putExtra("addCashScreenType", balanceFragment))
          // activity.getString(R.string.text_mybalance) -> activity.startActivity(Intent(activity, AddCashActivity::class.java))
            activity.getString(R.string.text_refer_earn) -> showErrorMessage(activity, "Coming Soon")
            activity.getString(R.string.text_how_to_play) -> showErrorMessage(activity,"Coming Soon")
            activity.getString(R.string.text_point_system) ->  showErrorMessage(activity,"Coming Soon")
           // activity.getString(R.string.text_myinfo_setting) -> activity.startActivity(Intent(activity, ProfileActivity::class.java))
            activity.getString(R.string.text_more) -> showErrorMessage(activity, "Coming Soon")
            activity.getString(R.string.text_logout)-> activity.openLogout()

            }
        activity.binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
    }

