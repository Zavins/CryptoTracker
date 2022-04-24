package com.example.cryptotracker
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.cryptotracker.fragments.HomeFragment
import com.example.cryptotracker.fragments.NewsFragment
import models.Crypto
import network.RestClient


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //This is an update.

        val fragmentManager: FragmentManager = supportFragmentManager

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener {
            item ->
            var fragmentToShow: Fragment? = null

            when (item.itemId) {
                R.id.action_home -> {
                    fragmentToShow = HomeFragment()
                }

                R.id.action_news -> {
                    fragmentToShow = NewsFragment()
                }
            }
            if (fragmentToShow != null) {
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragmentToShow).commit()
            }

            true
        }
        // Set default selection
        findViewById<BottomNavigationView>(R.id.bottom_navigation).selectedItemId = R.id.action_home


        //Testing APIs
        val restClient = RestClient()
        //example
        for (i in 1..10) {
            restClient.getCryptoInfoList(i) { cryptoList: List<Crypto> ->
                Log.i("TEST API", cryptoList.toString())
            }
            Thread.sleep(1200)
        }
    }
}