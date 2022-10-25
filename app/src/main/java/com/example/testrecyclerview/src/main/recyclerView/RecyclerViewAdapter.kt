package com.example.testrecyclerview.src.main.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testrecyclerview.databinding.RcvItemBinding

class RecyclerViewAdapter(private val itemsData: ArrayList<ItemsData>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    // item xml을 받아와 홀더를 만들어준다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val binding: RcvItemBinding = RcvItemBinding .inflate(LayoutInflater.from(parent.context), parent, false)
        // 아이템 레이아웃을 바인딩하여 연결 후 ViewHolder 클래스에 연결해준다.
        return ViewHolder(binding)
    }
    // 바인딩한 데이터를 홀더에 넣어준다.
    override fun onBindViewHolder(holder:  RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.bind(itemsData[position])
    }

    override fun getItemCount(): Int = itemsData.size

    inner class ViewHolder(private val binding:  RcvItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: ItemsData){
            // 아이템 레이아웃에서 정한 값들을 데이터클래스 값으로 넣어줌
            binding.rcvImage.setImageResource(data.Image)
            binding.tvTitle.text = data.title
            binding.tvNumber.text = data.number
        }
    }
}