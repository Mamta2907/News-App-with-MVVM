package com.mamta.mvvmnewsapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.mamta.mvvmnewsapp.R
import com.mamta.mvvmnewsapp.databinding.ActivityMainBinding
import com.mamta.mvvmnewsapp.fragment.NewsFragment
import com.mamta.mvvmnewsapp.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        loadFragment(NewsFragment())
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.news -> {
                    loadFragment(NewsFragment())
                    true
                }

                R.id.profile -> {
                    loadFragment(ProfileFragment())
                    true
                }

                else -> false
            }
        }

    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.container.id, fragment)
        //transaction.addToBackStack(null)
        transaction.commit()
    }

}