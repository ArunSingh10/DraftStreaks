package com.example.draftstreaks.utility

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.AlertDialogWithTwoButtonBinding
import com.example.draftstreaks.databinding.SimpleAlertDialogBinding
import com.example.draftstreaks.network.NetworkUtils
import com.example.draftstreaks.ui.login.LogInActivity

class AlertDialogView {
    companion object{

        fun showSimpleAlertDialog(
            context: Context,
            icon: Int,
            title: String,
            description: String,
            buttonText: String,
            onClick: () -> Unit
        ): Dialog {
            val dialog = Dialog(context)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            //dialog.window!!.attributes.windowAnimations = R.style.CustomDialog
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            val binding : SimpleAlertDialogBinding = SimpleAlertDialogBinding.inflate(LayoutInflater.from(context))
            dialog.setContentView(binding.root)

            binding.textViewBodyMsg1.isVisible = title.isNotEmpty()
            binding.textViewBodyMsg1.text = title

            binding.textViewBodyMsg2.isVisible = description.isNotEmpty()
            binding.textViewBodyMsg2.text = description

            binding.buttonDone.text = buttonText
            binding.buttonDone.setOnClickListener {
                dialog.dismiss()
                onClick()
            }
            binding.imageView.setImageResource(icon)

            dialog.setCancelable(false)
            dialog.dismiss()

            dialog.show()
            return dialog
        }

        @SuppressLint("SetTextI18n")
        fun showNetworkLostDialog(
            context: Context,
            description: String,
            loadPage: () -> Unit
        ): Dialog {
            val dialog = Dialog(context)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.window!!.attributes.windowAnimations = R.style.CustomDialog
            dialog.window!!.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
           // dialog.getWindow()!!.setBackgroundDrawable( ColorDrawable(Color.TRANSPARENT))
            dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent);

        /*    alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            alertDialog.setContentView(R.layout.tabs);
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));*/

            val binding : SimpleAlertDialogBinding = SimpleAlertDialogBinding.inflate(LayoutInflater.from(context))
            dialog.setContentView(binding.root)

            binding.textViewBodyMsg1.text = "Network Error"
            binding.textViewBodyMsg2.visibility = View.VISIBLE
            binding.textViewBodyMsg2.text = description
            binding.buttonDone.text = "Ok"

            binding.buttonDone.setOnClickListener {
              if(!NetworkUtils.isInternetAvailable(context)){
                    binding.textViewBodyMsg1.text = "Network Error"
                    binding.textViewBodyMsg2.text = description

                }
                else {
                    Utils.networkDialogShow = false
                    dialog.dismiss()
                    loadPage()
                }

            }
            binding.imageView.setImageResource(R.drawable.ic_warning)
            dialog.setCancelable(false)
            dialog.dismiss()

            dialog.show()
            return dialog
        }

        @SuppressLint("SetTextI18n")
        fun showSimpleDialog(
            context: Context,
            description: String,
            loadPage: () -> Unit
        ): Dialog {
            val dialog = Dialog(context)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.window!!.attributes.windowAnimations = R.style.CustomDialog
            dialog.window!!.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent);

            val binding : SimpleAlertDialogBinding = SimpleAlertDialogBinding.inflate(LayoutInflater.from(context))
            dialog.setContentView(binding.root)

      /*      binding.textViewBodyMsg1.text = "You Want to Remove Player"*/
            binding.textViewBodyMsg2.visibility = View.VISIBLE
            binding.textViewBodyMsg2.text = description
            binding.buttonDone.text = "Ok"

            binding.buttonDone.setOnClickListener {
                    dialog.dismiss()
                    loadPage()
            }
            binding.imageView.setImageResource(R.drawable.image_streak)
            dialog.setCancelable(true)
            dialog.dismiss()

            dialog.show()
            return dialog
        }
        fun showDialogWithTwoButton(
            context: Context,
            icon: Int,
            title: String,
            description: String,
            buttonNo: String,
            buttonYes: String,
            onButtonNo: () -> Unit,
            onButtonYes: () -> Unit,
        ): Dialog {
            val dialog = Dialog(context)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.window!!.attributes.windowAnimations = R.style.CustomDialog
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            val binding = AlertDialogWithTwoButtonBinding.inflate(LayoutInflater.from(context))
            dialog.setContentView(binding.root)

            binding.textViewBodyMsg1.isVisible = title.isNotEmpty()
            binding.textViewBodyMsg2.isVisible = description.isNotEmpty()
            binding.buttonNo.isVisible = buttonNo.isNotEmpty()
            binding.buttonYes.isVisible = buttonYes.isNotEmpty()

            binding.textViewBodyMsg1.text = title
            binding.textViewBodyMsg2.text = description
            binding.buttonNo.text = buttonNo
            binding.buttonYes.text = buttonYes
            binding.imageView.setImageResource(icon)

            binding.buttonYes.setOnClickListener{
                dialog.dismiss()
                onButtonYes()
            }

            binding.buttonNo.setOnClickListener{
                dialog.dismiss()
                onButtonNo()
            }

            dialog.setCancelable(false)
            dialog.dismiss()
            dialog.show()
            return dialog
        }
    }
}