package com.example.youthpick.presentation.main.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youthpick.R
import com.example.youthpick.databinding.ItemPagesBinding
import com.example.youthpick.presentation.main.item.MainPageItem
import com.example.youthpick.presentation.main.view.MainActivity
import com.example.youthpick.presentation.main.viewmodel.MainPagerViewModel


class ViewPagerAdapter(context: Context) :
    RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    lateinit var binding: ItemPagesBinding
    private val activity = context as MainActivity
    private val mainPagerViewModel = MainPagerViewModel()
    private val itemList = mainPagerViewModel.itemList.toList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        binding = ItemPagesBinding.inflate(inflater, parent, false)
        return PagerViewHolder(binding)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.onBind(itemList[position])
        holder.setPagerEvent(position, activity)
    }

    class PagerViewHolder(private val binding: ItemPagesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: MainPageItem) {
            data.image?.let { binding.ivPagerImage.setImageResource(it) }
            binding.tvPagerTitle.text = data.title
            binding.tvPagerDesc.text = data.description
        }

        fun setPagerEvent(position: Int, activity: MainActivity) {
            binding.pagerItem.setOnClickListener {
                when (position) {
                    0 -> {
                        activity.changeFragment(R.id.item_calendar)
                        activity.binding.bnvMain.selectedItemId = R.id.item_calendar
                    }
                    1 -> {
                        activity.changeFragment(R.id.item_chatbot)
                        activity.binding.bnvMain.selectedItemId = R.id.item_chatbot
                    }
                    2 -> {
                        activity.changeFragment(R.id.item_note)
                        activity.binding.bnvMain.selectedItemId = R.id.item_note
                    }
                    else -> Log.d("GIO", "error")
                }
            }
        }
    }
}