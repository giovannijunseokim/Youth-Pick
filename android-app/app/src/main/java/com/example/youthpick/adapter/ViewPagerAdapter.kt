package com.example.youthpick.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youthpick.R
import com.example.youthpick.databinding.ItemPagesBinding
import com.example.youthpick.models.PageItem
import com.example.youthpick.models.PagerViewModel
import kotlinx.coroutines.NonDisposableHandle.parent

class ViewPagerAdapter(context : Context) : RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var binding : ItemPagesBinding? = null
    val pagerViewModel = PagerViewModel()
    val itemList = pagerViewModel.itemList.toList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        binding = ItemPagesBinding.inflate(inflater, parent, false)
        return PagerViewHolder(binding!!)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    class PagerViewHolder(private val binding: ItemPagesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data : PageItem){
            data.image?.let { binding.ivPagerImage.setImageResource(it) }
            binding.tvPagerTitle.text = data.title
            binding.tvPagerDesc.text = data.description
        }
    }
}