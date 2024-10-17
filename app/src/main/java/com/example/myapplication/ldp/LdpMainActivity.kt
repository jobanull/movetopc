package com.example.myapplication.ldp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityLdpmainBinding
import com.example.myapplication.ldp.datastore.DataStoreMainActivity
import com.example.myapplication.ldp.openFile.OpenFileMainActivity
import com.example.myapplication.ldp.repository.ui.RepositoryMainActivity
import com.example.myapplication.ldp.room.RoomMainActivity
import com.example.myapplication.ldp.sharedPreferences.SharedPrefMainActivity
import com.example.myapplication.ldp.sqlite.SqlLiteMainActivity

class LdpMainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLdpmainBinding
    private lateinit var btnSqlLite : Button
    private lateinit var btnSharedPref : Button
    private lateinit var btnRoom : Button
    private lateinit var btnOpenFile : Button
    private lateinit var btnDataStore : Button
    private lateinit var btnRepository : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLdpmainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnRepository = binding.repository
        btnRoom = binding.room
        btnSqlLite = binding.sqlLite
        btnDataStore = binding.dataStore
        btnOpenFile = binding.openFile
        btnSharedPref = binding.sharePref

        btnSqlLite.setOnClickListener{
            val intent = Intent(this@LdpMainActivity, SqlLiteMainActivity::class.java)
            startActivity(intent)
        }

        btnSharedPref.setOnClickListener {
            val intent = Intent(this@LdpMainActivity, SharedPrefMainActivity::class.java)
            startActivity(intent)
        }

        btnRoom.setOnClickListener {
            val intent = Intent(this@LdpMainActivity, RoomMainActivity::class.java)
            startActivity(intent)
        }

        btnOpenFile.setOnClickListener {
            val intent = Intent(this@LdpMainActivity, OpenFileMainActivity::class.java)
            startActivity(intent)
        }

        btnDataStore.setOnClickListener {
            val intent = Intent(this@LdpMainActivity, DataStoreMainActivity::class.java)
            startActivity(intent)
        }

        btnRepository.setOnClickListener {
            val intent = Intent(this@LdpMainActivity, RepositoryMainActivity::class.java)
            startActivity(intent)
        }

    }
}