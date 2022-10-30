package com.example.youthpick.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.youthpick.MainActivity
import com.example.youthpick.adapter.ViewPagerAdapter
import com.example.youthpick.databinding.FragmentMainBinding
import com.example.youthpick.models.PageItem
import com.example.youthpick.models.PagerViewModel


class MainFragment ():Fragment(){
    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = requireNotNull(_binding){"binding이 널임"}
    private val adapter by lazy { ViewPagerAdapter(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.viewpager.adapter = adapter
        binding.viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.viewpager.setPadding(200, 0, 200, 0)
        binding.viewpager.setPageTransformer { page, position ->
            page.translationX = position * 150
        }

        binding.btnDrawerOpener.setOnClickListener {
            (activity as MainActivity).drawerOpen()
        }

        return binding.root
    }

    private fun getItemList(): List<PageItem> {
        val pagerViewModel = PagerViewModel()
        return pagerViewModel.itemList
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}