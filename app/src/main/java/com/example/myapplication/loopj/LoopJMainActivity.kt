package com.example.myapplication.loopj

import android.content.ContentValues.TAG
import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityLoopJmainBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class LoopJMainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoopJmainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoopJmainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getRandomQuote()
        binding.btnAllQuotes.setOnClickListener {
            startActivity(Intent(this@LoopJMainActivity, LoopJListQuoteActivity::class.java))
        }


    }

    private fun getRandomQuote(){
        binding.progressBar.visibility = View.VISIBLE
        val client = AsyncHttpClient()
        var url = "https://quote-api.dicoding.dev/random"
        client.get(url, object : AsyncHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<Header>,
                responseBody: ByteArray
            ) {
//                Jika Berhasil
                binding.progressBar.visibility = View.INVISIBLE
                val result = String(responseBody)
                Log.d(TAG, result)
                try {
                    val responseObject = JSONObject(result)
                    val quote = responseObject.getString("en")
                    val author = responseObject.getString("author")
                    binding.tvQuote.text = quote
                    binding.tvAuthor.text = author
                } catch (e :Exception){
                    Toast.makeText(this@LoopJMainActivity,e.message, Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
//                Jika Gagal
                binding.progressBar.visibility = View.INVISIBLE
                val errorMessage = when(statusCode){
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error?.message}"
                }
                Toast.makeText(this@LoopJMainActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}