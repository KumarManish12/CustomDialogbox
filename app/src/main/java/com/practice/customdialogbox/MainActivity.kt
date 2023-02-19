package com.practice.customdialogbox

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.practice.customdialogbox.databinding.ActivityMainBinding
import com.practice.customdialogbox.databinding.CustomDialogBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnnext.setOnClickListener {
            var customDialog = Dialog(this)
            var dialogBinding=CustomDialogBinding.inflate(layoutInflater)
            customDialog.setCancelable(false)
            customDialog.setContentView(dialogBinding.root)
            dialogBinding.btnok.setOnClickListener {
                if(dialogBinding.etgettext.text.toString().isEmpty()){
                    dialogBinding.etgettext.error = resources.getString(R.string.Enteryourname)
                }else {
                    binding.tvhelloworld.setText(dialogBinding.etgettext.text.toString())
                    customDialog.dismiss()
                }

            }
            dialogBinding.btncancel.setOnClickListener {
                customDialog.dismiss()
            }
            customDialog.show()
            }
        }
    }



