package com.example.myapplication.retrofit

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ActivityRetrofitMainBinding
import com.example.myapplication.retrofit.data.response.RetrofitCustomerReviewsItem
import com.example.myapplication.retrofit.data.response.RetrofitPostReviewResponse
import com.example.myapplication.retrofit.data.response.RetrofitRestaurant
import com.example.myapplication.retrofit.data.response.RetrofitRestaurantResponse
import com.example.myapplication.retrofit.data.retrofit.ApiConfigRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitMainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRetrofitMainBinding
    companion object {
        private const val TAG = "MainActivity"
        private const val RESTAURANT_ID = "uewq1zg2zlskfw1e867"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetrofitMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val layoutManager = LinearLayoutManager(this)
        binding.rvReview.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvReview.addItemDecoration(itemDecoration)
        findRestaurant()

        binding.btnSend.setOnClickListener { view ->
            postReview(binding.edReview.text.toString())
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun findRestaurant() {
        showLoading(true)
        val client = ApiConfigRetrofit.getApiService().getRestaurant(RESTAURANT_ID)
        client.enqueue(object : Callback<RetrofitRestaurantResponse> {
            override fun onResponse(
                call: Call<RetrofitRestaurantResponse>,
                response: Response<RetrofitRestaurantResponse>
            ) {
                showLoading(false)
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        setRestaurantData(responseBody.restaurant)
                        setReviewData(responseBody.restaurant.customerReviews)
                    }
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<RetrofitRestaurantResponse>, t: Throwable) {
                showLoading(false)
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }
    private fun setRestaurantData(restaurant: RetrofitRestaurant) {
        binding.tvTitle.text = restaurant.name
        binding.tvDescription.text = restaurant.description
        Glide.with(this@RetrofitMainActivity)
            .load("https://restaurant-api.dicoding.dev/images/large/${restaurant.pictureId}")
            .into(binding.ivPicture)
    }
    private fun setReviewData(consumerReviews: List<RetrofitCustomerReviewsItem>) {
        val adapter = ListReviewAdapter()
        adapter.submitList(consumerReviews)
        binding.rvReview.adapter = adapter
        binding.edReview.setText("")
    }
    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun postReview(review: String) {
        showLoading(true)
        val client = ApiConfigRetrofit.getApiService().postReview(RESTAURANT_ID, "Bons", review)
        client.enqueue(object : Callback<RetrofitPostReviewResponse> {
            override fun onResponse(
                call: Call<RetrofitPostReviewResponse>,
                response: Response<RetrofitPostReviewResponse>
            ) {
                showLoading(false)
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    setReviewData(responseBody.customerReviews)
                } else {
                    Log.e(TAG, "onFailures: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<RetrofitPostReviewResponse>, t: Throwable) {
                showLoading(false)
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }
}