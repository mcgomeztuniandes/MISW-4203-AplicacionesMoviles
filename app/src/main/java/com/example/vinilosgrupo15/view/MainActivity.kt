package com.example.vinilosgrupo15.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.view.fragments.AlbumListFragment
import com.example.vinilosgrupo15.view.fragments.BandListFragment
import com.example.vinilosgrupo15.view.fragments.CollectorListFragment
import com.example.vinilosgrupo15.view.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnPerformers = findViewById(R.id.performersBtn) as Button

        var btnHome = findViewById(R.id.homeBtn) as Button

        var btnAlbums = findViewById(R.id.albumsBtn) as Button

        var btnCollectors = findViewById(R.id.collectorsBtn) as Button

        btnHome.setBackgroundColor(ContextCompat.getColor(btnHome.context,R.color.btn_icon_selected_color))

        btnPerformers.setOnClickListener {
            loadFragment(BandListFragment())
            btnPerformers.setBackgroundColor(ContextCompat.getColor(btnHome.context,R.color.btn_icon_selected_color))
            btnCollectors.setBackgroundColor(ContextCompat.getColor(btnHome.context,R.color.btn_icon_color))
            btnAlbums.setBackgroundColor(ContextCompat.getColor(btnHome.context,R.color.btn_icon_color))
            btnHome.setBackgroundColor(ContextCompat.getColor(btnHome.context,R.color.btn_icon_color))
        }

        btnHome.setOnClickListener {
            loadFragment(HomeFragment())
            btnHome.setBackgroundColor(ContextCompat.getColor(btnHome.context,R.color.btn_icon_selected_color))
            btnCollectors.setBackgroundColor(ContextCompat.getColor(btnHome.context,R.color.btn_icon_color))
            btnAlbums.setBackgroundColor(ContextCompat.getColor(btnHome.context,R.color.btn_icon_color))
            btnPerformers.setBackgroundColor(ContextCompat.getColor(btnHome.context,R.color.btn_icon_color))
        }

        btnAlbums.setOnClickListener {
            loadFragment(AlbumListFragment())
            btnAlbums.setBackgroundColor(ContextCompat.getColor(btnHome.context,R.color.btn_icon_selected_color))
            btnCollectors.setBackgroundColor(ContextCompat.getColor(btnHome.context,R.color.btn_icon_color))
            btnHome.setBackgroundColor(ContextCompat.getColor(btnHome.context,R.color.btn_icon_color))
            btnPerformers.setBackgroundColor(ContextCompat.getColor(btnHome.context,R.color.btn_icon_color))
        }

        btnCollectors.setOnClickListener{
            loadFragment(CollectorListFragment())
            btnCollectors.setBackgroundColor(ContextCompat.getColor(btnHome.context,R.color.btn_icon_selected_color))
            btnHome.setBackgroundColor(ContextCompat.getColor(btnHome.context,R.color.btn_icon_color))
            btnAlbums.setBackgroundColor(ContextCompat.getColor(btnHome.context,R.color.btn_icon_color))
            btnPerformers.setBackgroundColor(ContextCompat.getColor(btnHome.context,R.color.btn_icon_color))
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