package com.example.myapplication.livedata

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityLiveDataMainBinding
import com.example.myapplication.livedata.withapi.LiveDataApiMainActivity

class LiveDataMainActivity : AppCompatActivity() {
    private lateinit var liveDataTimerViewModel: LiveDataViewModel
    private lateinit var binding: ActivityLiveDataMainBinding
    private lateinit var btnLdWithApi : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLiveDataMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnLdWithApi = binding.toLiveDataWithApi
        btnLdWithApi.setOnClickListener{
            startActivity(Intent(this@LiveDataMainActivity, LiveDataApiMainActivity::class.java))
        }
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