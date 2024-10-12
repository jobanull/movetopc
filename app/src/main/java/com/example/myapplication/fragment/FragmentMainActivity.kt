package com.example.myapplication.fragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityFragmentMainBinding

class FragmentMainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_main)
        binding = ActivityFragmentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager
        val homeFragment = HomeFragment()
        val fragment = fragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)
        if(fragment !is HomeFragment){
            fragmentManager
                .beginTransaction()
                .add(R.id.frame_container, homeFragment, HomeFragment::class.java.simpleName)
                .commit()
        }
    }
}