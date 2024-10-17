package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.fragment.FragmentMainActivity
import com.example.myapplication.ldp.LdpMainActivity
import com.example.myapplication.livedata.LiveDataMainActivity
import com.example.myapplication.loopj.LoopJMainActivity
import com.example.myapplication.navigation.NavigationMainActivity
import com.example.myapplication.recyclerView.RecycleViewMainActivity
import com.example.myapplication.retrofit.RetrofitMainActivity
import com.example.myapplication.task.TaskMainActivity
import com.example.myapplication.testing.TestingMainActivity
import com.example.myapplication.viewModel.ViewModelMainActivity

class MainActivity : AppCompatActivity(){
    private lateinit var binding : ActivityMainBinding
    private lateinit var btnRv : Button
    private lateinit var btnFragment : Button
    private lateinit var btnNavigation : Button
    private lateinit var btnLoopJ : Button
    private lateinit var btnRetrofit : Button
    private lateinit var btnViewModel : Button
    private lateinit var btnLiveData : Button
    private lateinit var btnLdp : Button
    private lateinit var btnTask : Button
    private lateinit var btnTesting : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnRv = binding.toRv
        btnFragment = binding.toFragment
        btnNavigation = binding.toNavigation
        btnLoopJ = binding.toLoopJ
        btnRetrofit = binding.toRetrofit
        btnViewModel = binding.toViewmodel
        btnLiveData = binding.toLiveData
        btnLdp = binding.toLdp
        btnTask = binding.toTask
        btnTesting = binding.toTesting

        btnRv.setOnClickListener {
            val intent = Intent(this@MainActivity, RecycleViewMainActivity::class.java)
            startActivity(intent)
        }

        btnFragment.setOnClickListener {
            val intent =  Intent(this@MainActivity, FragmentMainActivity::class.java)
            startActivity(intent)
        }

        btnNavigation.setOnClickListener {
            val intent = Intent(this@MainActivity, NavigationMainActivity::class.java)
            startActivity(intent)
        }

        btnLoopJ.setOnClickListener {
            val intent = Intent(this@MainActivity, LoopJMainActivity::class.java)
            startActivity(intent)
        }

        btnRetrofit.setOnClickListener {
            val intent = Intent(this@MainActivity, RetrofitMainActivity::class.java)
            startActivity(intent)
        }

        btnViewModel.setOnClickListener {
            val intent = Intent(this@MainActivity, ViewModelMainActivity::class.java)
            startActivity(intent)
        }

        btnLiveData.setOnClickListener {
            val intent = Intent(this@MainActivity, LiveDataMainActivity::class.java)
            startActivity(intent)
        }

        btnLdp.setOnClickListener {
            val intent = Intent(this@MainActivity, LdpMainActivity::class.java)
            startActivity(intent)
        }

        btnTask.setOnClickListener {
            val intent = Intent(this@MainActivity, TaskMainActivity::class.java)
            startActivity(intent)
        }

        btnTesting.setOnClickListener {
            val intent = Intent(this@MainActivity, TestingMainActivity::class.java)
            startActivity(intent)
        }
    }
}
