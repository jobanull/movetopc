package com.example.myapplication.navigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityNavigationMainBinding

class NavigationMainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNavigationMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}