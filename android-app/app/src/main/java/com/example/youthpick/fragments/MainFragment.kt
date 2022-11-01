package com.example.youthpick.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.youthpick.MainActivity
import com.example.youthpick.R
import com.example.youthpick.adapter.ViewPagerAdapter
import com.example.youthpick.databinding.FragmentMainBinding
import com.example.youthpick.databinding.ItemPagesBinding
import com.example.youthpick.models.PageItem
import com.example.youthpick.models.PagerViewModel


class MainFragment ():Fragment(){
    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = requireNotNull(_binding){"binding이 널임"}
    lateinit var itemPagesBinding: ItemPagesBinding
    private val adapter by lazy { ViewPagerAdapter(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.viewpager.adapter = adapter
        binding.viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.viewpager.setPadding(240, 0, 240, 0)
        binding.viewpager.setPageTransformer { page, position ->
            page.translationX = position * 150
        }

//        binding.viewpager.setOnClickListener{
//            Log.d("GIO", "No,,,,")
//            itemPagesBinding = ItemPagesBinding.inflate(layoutInflater)
//            itemPagesBinding.pagerItem.setOnClickListener {
//                when(itemPagesBinding.tvPagerTitle.text){
//                    "유스픽 캘린더 바로가기" -> {
//                        Log.d("GIO", "No,,,,")
//                        (activity as MainActivity).changeFragment(R.id.item_calendar)}
//                    "유스픽 챗봇 바로가기" ->
//                        (activity as MainActivity).changeFragment(R.id.item_chatbot)
//                    "메모 바로가기" ->
//                        (activity as MainActivity).changeFragment(R.id.item_note)
//                    else ->
//                        Log.d("GIO", "No,,,,")
//                }
//            }
//
//        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}