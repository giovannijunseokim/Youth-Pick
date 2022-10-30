package com.example.youthpick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Button
import com.example.youthpick.databinding.ActivityMainBinding
import com.example.youthpick.databinding.FragmentMainBinding
import com.example.youthpick.fragments.CalendarFragment
import com.example.youthpick.fragments.ChatbotFragment
import com.example.youthpick.fragments.MainFragment
import com.example.youthpick.fragments.NoteFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var fragmentMainBinding: FragmentMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firstFragment()
        binding.bnvMain.setOnItemSelectedListener { item ->
            changeFragment(item)
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
    private fun changeFragment(item : MenuItem) : Boolean{
        when(item.itemId) {
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