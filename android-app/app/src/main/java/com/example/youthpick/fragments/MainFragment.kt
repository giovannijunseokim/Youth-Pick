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

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}