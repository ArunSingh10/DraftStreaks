package com.example.draftstreaks.ui.home.activtiy.homeActivity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log.VERBOSE
import android.view.MenuItem

import android.view.View

import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.replace
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draftstreaks.AppUtils
import com.example.draftstreaks.AppUtils.Companion.getDrawerModel
import com.example.draftstreaks.PreferencesManager
import com.example.draftstreaks.R
import com.example.draftstreaks.addCash.AddCashActivity
import com.example.draftstreaks.addCash.BalanceActivity
import com.example.draftstreaks.constant.Constant
import com.example.draftstreaks.databinding.ActivityHomeBinding
import com.example.draftstreaks.databinding.NavHeaderDrawerBinding

import com.example.draftstreaks.network.NetworkUtils
import com.example.draftstreaks.ui.home.DrawerModel
import com.example.draftstreaks.ui.home.activtiy.profile.UserProfileActivity
import com.example.draftstreaks.ui.home.fragment.homeFragment.HomeFragment
import com.example.draftstreaks.ui.home.fragment.matchFragment.MatchesFragment
import com.example.draftstreaks.ui.home.fragment.supportFragment.SupportFragment
import com.example.draftstreaks.ui.home.fragment.winnerFragment.WinnerFragment
import com.example.draftstreaks.ui.login.LogInActivity
import com.example.draftstreaks.utility.Utils
import com.example.draftstreaks.utility.Utils.Companion.drawerOpenClose
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch
import javax.inject.Inject


class HomeActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityHomeBinding
    lateinit var navHeaderDrawerBinding: NavHeaderDrawerBinding
    lateinit var drawerModel: ArrayList<DrawerModel>
    lateinit var drawerItemAdapter: DrawerListAdapter
    lateinit var maneger: FragmentManager
    lateinit var transaction: FragmentTransaction
    @Inject
    lateinit var preferencesManager: PreferencesManager
    var homeFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        preferencesManager = PreferencesManager(this)
        setUp()
    }

    private fun setUp() {

        binding.parentImageWallets.setOnClickListener(this)

        checkAppPermission()
        bottomItem()
    }

    fun bottomItem() {
        val bottomNavigation = binding.bottomNavigationView
        openFragment(HomeFragment(), "homeFragment")

        bottomNavigation.menu.findItem(R.id.bottomViewHomes).isChecked = true
        bottomNavigation.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.bottomViewHomes -> {
                        val selected = item.isChecked
                        return if (selected) {
                            true
                        } else {
                            openFragment(HomeFragment(), "homeFragment")
                            true
                        }
                    }

                    R.id.bottomViewWinners -> {
                        val selected = item.isChecked
                        return if (selected) {
                            true
                        } else {
                            openFragment(WinnerFragment(), "winnerFragment")
                            true
                        }
                    }

                    R.id.bottomViewMatches -> {
                        val selected = item.isChecked
                        return if (selected) {
                            true
                        } else {
                            openFragment(MatchesFragment(), "myMatchesFragment")
                            true
                        }
                    }

                    R.id.bottomViewSupport -> {
                        val selected = item.isChecked
                        return if (selected) {
                            true

                        } else {
                            openFragment(SupportFragment(), "supportFragment")
                            true
                        }
                    }
                }
                return false
            }
        })

    }

    @SuppressLint("SuspiciousIndentation")
    fun openFragment(fragment: Fragment, tag: String) {
        maneger = supportFragmentManager
        transaction = maneger.beginTransaction()
        homeFragment = supportFragmentManager.findFragmentByTag(tag)
        /*  if (homeFragment == null) {*/

        transaction.apply {
            this.add(R.id.frameLayout, fragment, tag)
            this.addToBackStack(null)
            this.replace(R.id.frameLayout, fragment, tag)
            this.attach(fragment)
            this.setPrimaryNavigationFragment(fragment)
            this.show(fragment)
            this.runCatching { transaction.show(fragment) }
            this.commit()

            /*     }

             } else {
            transaction.apply {
                this.replace(R.id.frameLayout, fragment, tag)
                this.addToBackStack(null)
                this.commit()
            }*/

        }

    }


    private fun checkAppPermission() {

        if (!NetworkUtils.isInternetAvailable(this@HomeActivity)) {
            Utils.showNetworkLostAlertDialog(this@HomeActivity, "No Internet Available")
            {
                checkAppPermission()
            }
        } else {

            navHeaderDrawerBinding =
                NavHeaderDrawerBinding.bind(binding.drawerNavView.getHeaderView(0))
            binding.bottomNavigationView.itemIconTintList = null
            loadDrawerItems()

        }

    }

    fun loadDrawerItems() {
        drawerModel = getDrawerModel(applicationContext)
        drawerItemAdapter = DrawerListAdapter(this@HomeActivity)
        drawerItemAdapter.drawerModel = drawerModel

        navHeaderDrawerBinding.recyclerDrawer.apply {
            adapter = drawerItemAdapter
            layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
        }
    }

    fun navHeaderToolBarProfilesClickEvent(view: View) {
        drawerOpenClose(binding.drawerLayout)
    }

    fun walletBtnClickEvent(view: View) {
        startActivity(Intent(this@HomeActivity, BalanceActivity::class.java))
    }

    fun navHeaderLayoutBalanceClickEvent(view: View) {
        //  drawerOpenClose(binding.drawerLayout)
        startActivity(Intent(this@HomeActivity, AddCashActivity::class.java))
    }

    fun navHeaderLayoutInviteClickEvent(view: View) {
        //  drawerOpenClose(binding.drawerLayout)
        // startActivity(Intent(this, AddCashActivity::class.java))
    }

    fun navHelpSupportBtnClickEvent(view: View) {
        drawerOpenClose(binding.drawerLayout)
    }

    fun navHeaderUserProfileClickEvent(view: View) {
        //  drawerOpenClose(binding.drawerLayout)
        /* startActivity(
             Intent(applicationContext, UserProfileActivity::class.java)
         )*/
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.parentImagebell -> {
            }

            R.id.parentImageWallets -> {

                startActivity(Intent(this@HomeActivity, BalanceActivity::class.java))
            }

            R.id.homeProfileViews -> {
                drawerOpenClose(binding.drawerLayout)
            }
        }
    }

    fun openLogout() {
        Utils.showDialogWithTwoButton(
            this,
            R.drawable.ic_checkmark,
            title= "Logout",
            description = getString(R.string.logoutMsg),
            buttonYes = getString(R.string.yes),
            buttonNo = getString(R.string.no),
            onButtonYes = {logoutFromApp()},
            onButtonNo = {}
        )
    }
    private fun logoutFromApp() {

        preferencesManager.clearData()
        preferencesManager.setBoolean(Constant.logout,true)
        val intent = Intent(this, LogInActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finishAffinity()

    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        val visibleFragment = supportFragmentManager.findFragmentByTag("homeFragment")
        when {
            visibleFragment!!.tag.contentEquals("homeFragment") -> {
                finishAffinity()
            }

            binding.drawerLayout.isDrawerOpen(GravityCompat.START) -> binding.drawerLayout.closeDrawer(
                GravityCompat.START
            )

            else -> {
                if (visibleFragment.tag!!.contentEquals("winnerFragment") || visibleFragment.tag!!.contentEquals(
                        "myMatchesFragment"
                    ) || visibleFragment.tag!!.contentEquals("supportFragment")
                )
                    binding.bottomNavigationView.menu.findItem(R.id.bottomViewHomes).isChecked =
                        true
                openFragment(HomeFragment(), "homeFragment")

            }
        }
    }
}

