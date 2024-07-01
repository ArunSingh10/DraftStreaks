package com.example.draftstreaks.ui.joinContest.fragment.teamFragment


import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draftstreaks.R
import com.example.draftstreaks.clickInterface.PlayerClickListener
import com.example.draftstreaks.constant.Constant
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.databinding.BigBoardBoxBinding
import com.example.draftstreaks.databinding.FragmentTeamBinding
import com.example.draftstreaks.databinding.ListConfirmationDialogBinding
import com.example.draftstreaks.databinding.ListEstimatedPointBinding
import com.example.draftstreaks.localModel.TeamModel
import com.example.draftstreaks.localModel.getTeam
import com.example.draftstreaks.ui.joinContest.activity.JoinContestActivity
import com.example.draftstreaks.ui.joinContest.activity.PrizePoolActivity
import com.example.draftstreaks.ui.joinContest.activity.selectPlayerActvitiy.SelectPlayerActivity
import com.example.draftstreaks.ui.joinContest.fragment.prizePoolFragment.pointSystemFragment.PointSystemFragment
import com.example.draftstreaks.ui.joinContest.fragment.selectPlayer.GridBigBoardAdapter
import com.example.draftstreaks.ui.joinContest.fragment.selectPlayer.GridViewModal
import com.example.draftstreaks.utility.Utils.Companion.setupToolbar
import io.feeeei.circleseekbar.CircleSeekBar
import java.util.Objects


class TeamFragment : Fragment(), View.OnClickListener, PlayerClickListener {

    private lateinit var gridView: BigBoardBoxBinding
    private lateinit var progressBar1: CircleSeekBar
    private lateinit var progressBar2: CircleSeekBar
    lateinit var binding: FragmentTeamBinding
    lateinit var mActivity: PrizePoolActivity
    lateinit var teamAdapter: TeamAdapter
    lateinit var griddapter: GridBigBoardAdapter
    lateinit var showTeamModel: ArrayList<TeamModel>
    var isSelect: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_team, container, false)

        setUp()

        return binding.root
    }

    fun setUp() {
        mActivity = activity as PrizePoolActivity
        mActivity.setupToolbar(binding.includeToolbar.toolbar, binding.includeToolbar.textViewToolbarTitle, "Team", R.drawable.back_arrow) { mActivity.onBackPressed() }
        loadScreen()
        setProgress(0.0)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun loadScreen() {
        if (ScreenConstant.isEdit == "Yes" ) {
            binding.btnSubmit.setOnClickListener(this)
            binding.cardProgressScore.setOnClickListener(this)
            showTeamModel = getTeam()
            teamAdapter = TeamAdapter(mActivity, this)
            binding.recyclerTeam.adapter = teamAdapter
            binding.recyclerTeam.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            teamAdapter.teamModel = showTeamModel
            binding.recyclerTeam.setHasFixedSize(true)
            teamAdapter.setClickListener(this)
            teamAdapter.notifyDataSetChanged()
        }else{
            binding.btnSubmit.setOnClickListener(this)
            binding.cardProgressScore.setOnClickListener(this)
            showTeamModel = getTeam()
            teamAdapter = TeamAdapter(mActivity, this)
            binding.recyclerTeam.adapter = teamAdapter
            binding.recyclerTeam.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            teamAdapter.teamModel = showTeamModel
            binding.recyclerTeam.setHasFixedSize(true)
            teamAdapter.setClickListener(this)
            teamAdapter.notifyDataSetChanged()
        }

    }


    fun setProgress(cp: Double) {
        val progressBar = binding.seekbar
        progressBar.maxProcess = 1000
        progressBar.curProcess = cp.toInt()
        binding.textValueScore.text = cp.toString()
    }


    override fun onClick(p0: View?) {
        when (p0!!.id) {

            R.id.cardProgressScore -> {
                /*bigBoard(mActivity)*/
                showBigBoardBox()
            }
            R.id.btnSubmit -> {
                showConfimationDialog()
            }
        }
    }

    fun showBigBoardBox() {

        val dialog = Dialog(mActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window!!.attributes.windowAnimations = R.style.CustomDialog
        Objects.requireNonNull<Window>(dialog.window).setGravity(Gravity.CENTER)
        Objects.requireNonNull<Window>(dialog.window).setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )

       gridView  = BigBoardBoxBinding.inflate(LayoutInflater.from(context))

        dialog.setContentView(gridView.root)

        griddapter = GridBigBoardAdapter(showTeamModel, mActivity)
        gridView.gridViewBigBoard.adapter = griddapter
        gridView.gridViewBigBoard.numColumns = 6
        setProgressGrid1(610.24)
        setProgressGrid2(650.20)

        gridView.cardProgress1.setOnClickListener {
            dialog.dismiss()
            showEstimatedPointDialog()
        }

        gridView.buttonPointSystem.setOnClickListener {

            mActivity.openFragment(PointSystemFragment(), ScreenConstant.pointSystem)
            dialog.dismiss()
        }
        dialog.setCancelable(true)
        dialog.dismiss()
        dialog.show()
    }

    fun setProgressGrid1(cp: Double) {
        progressBar1 = gridView.seekbar1
        gridView.textValueScore1.text = cp.toString()
        progressBar1.maxProcess = 1000
        progressBar1.curProcess = cp.toInt()
    }
    fun setProgressGrid2(cp: Double) {

        progressBar2 = gridView.seekbar2
        gridView.textValueScore2.text = cp.toString()
        progressBar2.maxProcess = 1000
        progressBar2.curProcess = cp.toInt()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onTeamSelectClick(position: Int) {

        val playerName = showTeamModel[position].playerName
        isSelect = playerName.isNotEmpty()

        val intent = Intent(requireActivity(), SelectPlayerActivity::class.java)
            .putExtra("positionTeam", position)
            .putExtra("isSelect", isSelect)
            .putExtra("playerName", playerName)

        startActivityForResult(intent, Constant.REQUEST_PLAYER_SELECT)

    }

    @SuppressLint("NotifyDataSetChanged")
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        /*  try {*/
        if (requestCode == Constant.REQUEST_PLAYER_SELECT) {
            val dataFound = data?.getStringExtra("data") ?: ""

            if (dataFound != "back") {
                val position = data?.getIntExtra("positionTeam", -1)
                val playerName = data?.getStringExtra("playerName") ?: ""
                val isPlayerSelect = playerName.isNotEmpty()
                val completePlayerModel = showTeamModel

                if (position != -1) {
                    if (ScreenConstant.isEdit == "Yes" ){
                        showTeamModel[position!!].playerName = playerName
                        showTeamModel[position].isSelect = isPlayerSelect
                        teamAdapter.teamModel = showTeamModel
                        teamAdapter.notifyDataSetChanged()
                        binding.btnSubmit.visibility = View.VISIBLE
                    }else{
                        showTeamModel[position!!].playerName = playerName
                        showTeamModel[position].isSelect = isPlayerSelect
                        teamAdapter.teamModel = showTeamModel
                        teamAdapter.notifyDataSetChanged()
                        binding.btnSubmit.visibility = View.VISIBLE
                    }

                }
            }
        }
    }


    fun showEstimatedPointDialog() {

        val dialog = Dialog(mActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window!!.attributes.windowAnimations = R.style.CustomDialog
        Objects.requireNonNull<Window>(dialog.window).setGravity(Gravity.CENTER)
        Objects.requireNonNull<Window>(dialog.window).setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )

        val binding: ListEstimatedPointBinding =
            ListEstimatedPointBinding.inflate(LayoutInflater.from(context))

        dialog.setContentView(binding.root)

        dialog.setCancelable(true)
        dialog.dismiss()
        dialog.show()
    }

    @SuppressLint("SuspiciousIndentation")
    fun showConfimationDialog(){

        val dialog = Dialog(mActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window!!.attributes.windowAnimations = R.style.CustomDialog
        Objects.requireNonNull<Window>(dialog.window).setGravity(Gravity.CENTER)
        Objects.requireNonNull<Window>(dialog.window)
            .setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )

        val binding: ListConfirmationDialogBinding = ListConfirmationDialogBinding.inflate(LayoutInflater.from(context))

        dialog.setContentView(binding.root)

        binding.btnSubmitDraft.setOnClickListener {
            startActivity(Intent(mActivity,JoinContestActivity::class.java))
            ScreenConstant.fromTabConfimationPosition = 1
                mActivity.finish()
        }
        binding.imageCloseDialog.setOnClickListener{
            dialog.dismiss()
        }


        dialog.setCancelable(true)
        dialog.dismiss()
        dialog.show()
    }
}