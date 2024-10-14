package com.example.myapplication.task

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityTaskMainBinding
import com.example.myapplication.task.alarm.AlarmMainActivity
import com.example.myapplication.task.backTask.BackTaskMainActivity
import com.example.myapplication.task.broadcastReceiver.BroadcastReceiverMainActivity
import com.example.myapplication.task.notification.NotificationMainActivity
import com.example.myapplication.task.scheduler.SchedulerMainActivity

class TaskMainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTaskMainBinding
    private lateinit var btnAlarm : Button
    private lateinit var btnBroadcastReceiver : Button
    private lateinit var btnNotification : Button
    private lateinit var btnShceduler : Button
    private lateinit var btnBackTask : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnAlarm = binding.btnAlarm
        btnBroadcastReceiver = binding.btnBroadcastReceiver
        btnNotification = binding.btnNotification
        btnShceduler = binding.btnShceduler
        btnBackTask = binding.btnBackTask

        btnAlarm.setOnClickListener {
            val intent = Intent(this@TaskMainActivity, AlarmMainActivity::class.java)
            startActivity(intent)
        }

        btnBroadcastReceiver.setOnClickListener {
            val intent = Intent(this@TaskMainActivity, BroadcastReceiverMainActivity::class.java)
            startActivity(intent)
        }

        btnNotification.setOnClickListener {
            val intent = Intent(this@TaskMainActivity, NotificationMainActivity::class.java)
            startActivity(intent)
        }

        btnShceduler.setOnClickListener {
            val intent = Intent(this@TaskMainActivity, SchedulerMainActivity::class.java)
            startActivity(intent)
        }

        btnBackTask.setOnClickListener {
            val intent = Intent(this@TaskMainActivity, BackTaskMainActivity::class.java)
            startActivity(intent)
        }
    }

}