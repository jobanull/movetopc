package com.example.myapplication.livedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityLiveDataMainBinding

class LiveDataMainActivity : AppCompatActivity() {
    private lateinit var liveDataTimerViewModel: LiveDataViewModel
    private lateinit var binding: ActivityLiveDataMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLiveDataMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        liveDataTimerViewModel = ViewModelProvider(this)[LiveDataViewModel::class.java]
        subscribe()
    }

    private fun subscribe() {
        val elapsedTimeObserver = Observer<Long?> { aLong ->
            val newText = this@LiveDataMainActivity.resources.getString(R.string.seconds, aLong)
            binding.timerTextview.text = newText
        }
        liveDataTimerViewModel.getElapsedTime().observe(this, elapsedTimeObserver)
    }
}