package com.example.myapplication.recyclerView

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityRecycleViewMainBinding

class RecycleViewMainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRecycleViewMainBinding
    private lateinit var rvHeroes : RecyclerView
    private var list = ArrayList<Hero>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecycleViewMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvHeroes = binding.rvHeroes
        rvHeroes.setHasFixedSize(true)

        showRecycleViewList()

        list.addAll(listHeroes)
    }

    private val listHeroes : ArrayList<Hero>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDesc = resources.getStringArray(R.array.data_description)
            val dataPhoto = resources.getStringArray(R.array.data_photo)
            val listHero = ArrayList<Hero>()
            for( i in dataName.indices){
                val hero = Hero(dataName[i], dataDesc[i], dataPhoto[i])
                listHero.add(hero)
            }

            return listHero
        }
    private fun showSelectedHero(data: Hero){
        Toast.makeText(this, "Kamu Memilih ${data.name}",Toast.LENGTH_SHORT).show()
    }

    private fun showRecycleViewList(){
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })
    }


//    Option

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_list -> {
              rvHeroes.layoutManager =  LinearLayoutManager(this)
            }

            R.id.action_grid -> {
                rvHeroes.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}