package com.example.testrecyclerview.src.main

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.testrecyclerview.R
import com.example.testrecyclerview.config.BaseActivity
import com.example.testrecyclerview.databinding.ActivityMainBinding
import com.example.testrecyclerview.src.main.recyclerView.ItemsData
import com.example.testrecyclerview.src.main.recyclerView.RecyclerViewAdapter
import com.google.android.material.button.MaterialButton

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    var itemsData = ArrayList<ItemsData>()
    private val recyclerViewAdapter = RecyclerViewAdapter(itemsData)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        itemsData.apply {
            add(ItemsData(R.drawable.ic_launcher_foreground, "리사이클러뷰${itemsData.size+1}", "${itemsData.size+1} 번입니다."))
            add(ItemsData(R.drawable.ic_launcher_background, "리사이클러뷰${itemsData.size+1}", "${itemsData.size+1} 번입니다."))
            add(ItemsData(R.drawable.ic_launcher_foreground, "리사이클러뷰${itemsData.size+1}", "${itemsData.size+1} 번입니다."))
            add(ItemsData(R.drawable.ic_launcher_background, "리사이클러뷰${itemsData.size+1}", "${itemsData.size+1} 번입니다."))
            add(ItemsData(R.drawable.ic_launcher_foreground, "리사이클러뷰${itemsData.size+1}", "${itemsData.size+1} 번입니다."))
            add(ItemsData(R.drawable.ic_launcher_background, "리사이클러뷰${itemsData.size+1}", "${itemsData.size+1} 번입니다."))
            add(ItemsData(R.drawable.ic_launcher_foreground, "리사이클러뷰${itemsData.size+1}", "${itemsData.size+1} 번입니다."))
        }

        binding.rcvGoods.adapter = recyclerViewAdapter

        recyclerViewAdapter.setCustomItemClickListener(object: RecyclerViewAdapter.CustomItemClickListener{
            // 아이템 데이터 전달, 포지션 전달
            override fun onItemClick(itemsData: ItemsData, position: Int) {
                editDialog(itemsData.title, itemsData.number, position)
            }
        })

        binding.fbtAddItem.setOnClickListener {
            recyclerViewAdapter.addItem()
        }
    }

    fun editDialog(title: String, content: String, position: Int){
        AlertDialog.Builder(this)
            .setView(R.layout.dialog_edit)
            .show()
            .also { alertDialog ->

                if(alertDialog == null) {
                    return@also
                }

                alertDialog.findViewById<EditText>(R.id.et_title)?.setText("$title")
                alertDialog.findViewById<EditText>(R.id.et_content)?.setText("$content")

                val btEdit = alertDialog.findViewById<MaterialButton>(R.id.bt_edit)
                val btDelete = alertDialog.findViewById<MaterialButton>(R.id.bt_delete)

                btEdit?.setOnClickListener {
                    alertDialog.dismiss()
                    val editTitle = alertDialog.findViewById<EditText>(R.id.et_title)?.text.toString()
                    val editContent = alertDialog.findViewById<EditText>(R.id.et_content)?.text.toString()
                    recyclerViewAdapter.editItem(position, editTitle, editContent)
                }
                btDelete?.setOnClickListener{
                    recyclerViewAdapter.removeItem(position)
                    alertDialog.dismiss()
                }
            }
    }
}