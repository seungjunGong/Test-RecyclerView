package com.example.testrecyclerview.src.main.recyclerView


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testrecyclerview.R
import com.example.testrecyclerview.databinding.RcvItemBinding

class RecyclerViewAdapter(private val itemsData: ArrayList<ItemsData>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    // 아이템 클릭시 interface로 클래스 선언
    interface CustomItemClickListener{
        // 아이템 데이터를 받는 매개 변수 추가, 포지션 값 추가
        fun onItemClick(itemsData: ItemsData, position: Int)
    }

    fun addItem(){
        // 데이터 추가
        itemsData.add(ItemsData(R.drawable.ic_launcher_foreground, "리사이클러뷰${itemsData.size+1}", "${itemsData.size+1} 번입니다."))
        // 데이터 추가 함수
        notifyItemInserted(itemsData.size)
    }

    // 아이템 수정 함수
    fun editItem(position: Int, editTitle: String, editContent: String){
        // 데이터 변경
        itemsData[position] = ItemsData(itemsData[position].Image, editTitle, editContent)
        // 해당 아이템만 변경
        notifyItemChanged(position)
    }

    // 아이템 삭제 함수
    fun removeItem(position: Int){
        itemsData.removeAt(position)
        // 전체 아이템 크기 및 아이템 변경
        notifyDataSetChanged()
    }

    // 전달된 객체를 저장할 변수 추가
    private lateinit var cItemClickListener: CustomItemClickListener
    // 리스너 객체를 전달하는 메서드
    fun setCustomItemClickListener(itemClickListener: CustomItemClickListener){
        cItemClickListener = itemClickListener
    }

    // item xml을 받아와 홀더를 만들어준다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val binding: RcvItemBinding = RcvItemBinding .inflate(LayoutInflater.from(parent.context), parent, false)
        // 아이템 레이아웃을 바인딩하여 연결 후 ViewHolder 클래스에 연결해준다.
        return ViewHolder(binding)
    }
    // 바인딩한 데이터를 홀더에 넣어준다.
    override fun onBindViewHolder(holder:  RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.bind(itemsData[position])
        // 아이템 데이터 및 포지션값 추가
        holder.itemView.setOnClickListener { cItemClickListener.onItemClick(itemsData[position], position) } // 해당 포지션에 해당하는 데이터 전달
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