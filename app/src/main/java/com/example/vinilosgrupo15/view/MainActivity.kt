package com.example.vinilosgrupo15.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.view.fragments.BandListFragment
import com.example.vinilosgrupo15.view.fragments.HomeFragment
import com.example.vinilosgrupo15.view.fragments.MusicianListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnPerformers = findViewById(R.id.performersBtn) as Button

        var btnHome = findViewById(R.id.homeBtn) as Button

        btnPerformers.setOnClickListener {
            loadFragment(BandListFragment())
        }

        btnHome.setOnClickListener {
            loadFragment(HomeFragment())
        }

        loadFragment(HomeFragment())
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}