package com.example.youthpick.presentation.main.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.youthpick.databinding.FragmentMainBinding
import com.example.youthpick.presentation.main.adapter.ViewPagerAdapter
import com.example.youthpick.presentation.main.view.MainActivity
import com.example.youthpick.presentation.search.view.SearchActivity


class MainFragment() : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = requireNotNull(_binding) { "binding이 널임" }
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
            page.translationX = position * 200
        }

        binding.btnPagerLeft.setOnClickListener {
            when (binding.viewpager.currentItem) {
                1 -> {
                    binding.viewpager.setCurrentItem(0, true)
                }
                2 -> {
                    binding.viewpager.setCurrentItem(1, true)
                }
            }
        }
        binding.btnPagerRight.setOnClickListener {
            when (binding.viewpager.currentItem) {
                0 -> {
                    binding.viewpager.setCurrentItem(1, true)
                }
                1 -> {
                    binding.viewpager.setCurrentItem(2, true)
                }
            }
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val intent = Intent(requireContext(), SearchActivity::class.java)
                startActivity(intent)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })

        val wormDotsIndicator = binding.wormDotsIndicator
        wormDotsIndicator.attachTo(binding.viewpager)

        binding.btnDrawerOpener.setOnClickListener {
            (activity as MainActivity).drawerOpen()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}