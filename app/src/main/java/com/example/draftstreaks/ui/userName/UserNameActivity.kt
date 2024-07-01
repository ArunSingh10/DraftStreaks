package com.example.draftstreaks.ui.userName

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.draftstreaks.R
import com.example.draftstreaks.constant.Constant
import com.example.draftstreaks.databinding.ActivityUserNameBinding
import com.example.draftstreaks.ui.home.activtiy.homeActivity.HomeActivity
import com.example.draftstreaks.utility.Utils
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

class UserNameActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var binding:ActivityUserNameBinding
    lateinit var dialog: BottomSheetDialog
    private var actualImage: File? = null
    private var picturePath: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_user_name)
        loadPage()
    }

    private fun loadPage() {
        dialog = BottomSheetDialog(this)
        binding.buttonSaveName.setOnClickListener(this)
        binding.cameraIcon.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
     when(p0!!.id){
         R.id.cameraIcon->{
             Utils.checkStoragePermissions(this) { showBottomSheetDialog() }
         }
         R.id.buttonSaveName->{
             startActivity(Intent(this, HomeActivity::class.java))
         }
     }
    }
    private fun showBottomSheetDialog() :View{
        val view:View = View.inflate(this,R.layout.bottom_sheet_dialog_box,null)
        view.setBackgroundResource(R.drawable.white_background)
        dialog.setContentView(view)
        val layoutUploadFiles = dialog.findViewById<ImageView>(R.id.selectFiles)
        val layoutUploadCamera = dialog.findViewById<ImageView>(R.id.selectCamera)

        layoutUploadFiles?.setOnClickListener {
            openGallery()
        }

        layoutUploadCamera?.setOnClickListener {
            captureImageFromCamera()
        }

        dialog.show()
        return view
    }
    @Suppress("DEPRECATION")
    private fun captureImageFromCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, Constant.REQUEST_PERMISSION_CODE_CAMERA)
    }

    @Suppress("DEPRECATION")
    private fun openGallery() {
        val i = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(i, Constant.RESULT_LOAD_IMAGE)
    }
    @Suppress("DEPRECATION")
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == Constant.RESULT_LOAD_IMAGE && resultCode == Activity.RESULT_OK && null != data) {

            val selectedImage = data.data
            val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
            val cursor = this.contentResolver.query(selectedImage!!, filePathColumn, null, null, null)
            cursor!!.moveToFirst()
            val columnIndex = cursor.getColumnIndex(filePathColumn[0])
            val picturePaths = cursor.getString(columnIndex)
            cursor.close()
            binding.userProfile.setImageBitmap(BitmapFactory.decodeFile(picturePaths))
            dialog.dismiss()
            actualImage = File(picturePaths)

            if (actualImage!!.exists()) {
                picturePath= actualImage?.absolutePath.toString()



                // Toast.makeText(this, "Suesses", Toast.LENGTH_LONG ).show()
                dialog.dismiss()
            } else {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG ).show()
            }


        }
        else if (requestCode == Constant.REQUEST_PERMISSION_CODE_CAMERA && resultCode == Activity.RESULT_OK && null != data) {
            //val photo = data!!.extras!!["data"] as Bitmap?
            val selectedImage = data.extras!!["data"] as Bitmap
            val file: File?
            file = File(this.cacheDir,"image.png")
            file.createNewFile()
            //Convert bitmap to byte array
            val bos = ByteArrayOutputStream()
            selectedImage.compress(Bitmap.CompressFormat.PNG,0, bos) // YOU can also save it in JPEG
            val bitmapdata = bos.toByteArray()
            //write the bytes in file
            val fos = FileOutputStream(file)
            actualImage = file
            fos.write(bitmapdata)
            fos.flush()
            fos.close()
            picturePath=actualImage!!.absolutePath.toString()

            binding.userProfile.setImageBitmap(selectedImage)

            dialog.dismiss()

        }
        else{
            Log.d("errorData",resultCode.toString())
            dialog.dismiss()
        }

    }
}