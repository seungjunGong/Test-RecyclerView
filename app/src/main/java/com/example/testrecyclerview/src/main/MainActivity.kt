package com.example.testrecyclerview.src.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testrecyclerview.R
import com.example.testrecyclerview.config.BaseActivity
import com.example.testrecyclerview.databinding.ActivityMainBinding
import com.example.testrecyclerview.src.main.recyclerView.ItemsData
import com.example.testrecyclerview.src.main.recyclerView.RecyclerViewAdapter

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var itemsData = ArrayList<ItemsData>()
        var i = 1
        itemsData.apply {
            add(ItemsData(R.drawable.ic_launcher_foreground, "리사이클러뷰", "$i 번입니다."))
            i++
            add(ItemsData(R.drawable.ic_launcher_background, "리사이클러뷰", "$i 번입니다."))
            i++
            add(ItemsData(R.drawable.ic_launcher_foreground, "리사이클러뷰", "$i 번입니다."))
            i++
            add(ItemsData(R.drawable.ic_launcher_background, "리사이클러뷰", "$i 번입니다."))
            i++
            add(ItemsData(R.drawable.ic_launcher_foreground, "리사이클러뷰", "$i 번입니다."))
            i++
            add(ItemsData(R.drawable.ic_launcher_background, "리사이클러뷰", "$i 번입니다."))
            i++
            add(ItemsData(R.drawable.ic_launcher_foreground, "리사이클러뷰", "$i 번입니다."))
            i++
        }

        val recyclerViewAdapter = RecyclerViewAdapter(itemsData)
        binding.rcvGoods.adapter = recyclerViewAdapter
    }
}