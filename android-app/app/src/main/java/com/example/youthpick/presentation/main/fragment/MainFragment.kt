package com.example.youthpick.presentation.main.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.youthpick.databinding.FragmentMainBinding
import com.example.youthpick.presentation.main.adapter.ViewPagerAdapter
import com.example.youthpick.presentation.main.view.MainActivity
import com.example.youthpick.presentation.search.view.SearchActivity
import com.example.youthpick.util.extension.hideKeyboard

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
        binding.layout.setOnClickListener { requireContext().hideKeyboard(it) }

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
                when (query) {
                    "청년 이사비 지원" -> {
                        startActivity(
                            Intent(requireContext(), SearchActivity::class.java)
                                .putExtra(
                                    "keyword",
                                    "https://youth.seoul.go.kr/site/main/customSupp/mainView?bizId=A2022090700300200100000363"
                                )
                        )
                    }
                    "학자금 대출" -> {
                        startActivity(
                            Intent(requireContext(), SearchActivity::class.java)
                                .putExtra(
                                    "keyword",
                                    "https://youth.seoul.go.kr/site/main/customSupp/mainView?bizId=A2022031600300200100000014"
                                )
                        )
                    }
                    "희망 두배 청년 통장" -> {
                        startActivity(
                            Intent(requireContext(), SearchActivity::class.java)
                                .putExtra(
                                    "keyword",
                                    "https://youth.seoul.go.kr/site/main/customSupp/mainView?bizId=A2022031600300200100000013"
                                )
                        )
                    }
                    else -> {
                        startActivity(
                            Intent(
                                requireContext(),
                                SearchActivity::class.java
                            )
                                .putExtra("keyword", "https://youth.seoul.go.kr/search/search.s")
                        )
                        Toast.makeText(
                            requireContext(), "검색어를 다시 한 번 입력해주세요.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
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