package com.example.youthpick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import com.example.youthpick.databinding.ActivityMainBinding
import com.example.youthpick.databinding.FragmentMainBinding
import com.example.youthpick.databinding.ItemPagesBinding
import com.example.youthpick.fragments.CalendarFragment
import com.example.youthpick.fragments.ChatbotFragment
import com.example.youthpick.fragments.MainFragment
import com.example.youthpick.fragments.NoteFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var itemPagesBinding: ItemPagesBinding
    lateinit var fragmentMainBinding: FragmentMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firstFragment()
        binding.bnvMain.setOnItemSelectedListener { item ->
            changeFragment(item.itemId)
        }

        binding.btnDrawerOpener.setOnClickListener {
            drawerOpen()
        }

        itemPagesBinding = ItemPagesBinding.inflate(layoutInflater)
        itemPagesBinding.pagerItem.setOnClickListener {
            when(itemPagesBinding.tvPagerTitle.text){
                "유스픽 캘린더 바로가기" -> {
                    Toast.makeText(this, "캘린더 화면으로 이동", Toast.LENGTH_SHORT).show()
                    changeFragment(R.id.item_calendar)}
                "유스픽 챗봇 바로가기" ->
                    changeFragment(R.id.item_chatbot)
                "메모 바로가기" ->
                    changeFragment(R.id.item_note)
                else ->
                    Toast.makeText(this, "오류 발생", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun firstFragment(){
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view)
        if(currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view, MainFragment())
                .commit()
        }
    }
    fun changeFragment(itemId : Int) : Boolean{
        when(itemId) {
            R.id.item_main -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, MainFragment())
                    .commit()
                return true
            }
            R.id.item_calendar -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, CalendarFragment())
                    .commit()
                return true
            }
            R.id.item_chatbot -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, ChatbotFragment())
                    .commit()
                return true
            }
            R.id.item_note -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, NoteFragment())
                    .commit()
                return true
            }
            else -> return false
        }
    }
    fun drawerOpen(){
        binding.drawer.openDrawer(Gravity.LEFT)
    }
}