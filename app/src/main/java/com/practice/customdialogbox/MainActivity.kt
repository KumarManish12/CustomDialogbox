package com.practice.customdialogbox

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.practice.customdialogbox.databinding.ActivityMainBinding
import com.practice.customdialogbox.databinding.CustomDialogBinding
import com.practice.customdialogbox.databinding.EditCustomDialogBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: ArrayAdapter<*>
     var userList=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,userList)
        binding.lvlist1.adapter=adapter
        binding.lvlist1.setOnItemClickListener { adapterView, view, i, l ->
            var customDialog1=Dialog(this)
            var dialogBinding1=EditCustomDialogBinding.inflate(layoutInflater)
            customDialog1.setContentView(dialogBinding1.root)
            dialogBinding1.btnok1.setOnClickListener {
                if (dialogBinding1.etedittext.text.toString().isEmpty()){
                    dialogBinding1.etedittext.error="Enter text for edit"
                }
                else{
                    
                    userList.set(i, dialogBinding1.etedittext.text.toString())
                    adapter.notifyDataSetChanged()
                    customDialog1.dismiss()
                }
            }
            dialogBinding1.btndelete.setOnClickListener {
                userList.removeAt(i)
                customDialog1.dismiss()
            }
            customDialog1.show()
        }
        binding.floatbtnnext.setOnClickListener {
            var customDialog = Dialog(this)
            var dialogBinding=CustomDialogBinding.inflate(layoutInflater)
            customDialog.setCancelable(false)
            customDialog.setContentView(dialogBinding.root)
            dialogBinding.btnok.setOnClickListener {
                if(dialogBinding.etgettext.text.toString().isEmpty()){
                    dialogBinding.etgettext.error = resources.getString(R.string.Enteryourname)
                }else {
                    userList.add(dialogBinding.etgettext.text.toString())
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





