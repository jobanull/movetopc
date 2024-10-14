package com.example.myapplication.livedata.withapi

import LiveDataCustomerReviewsItem
import LiveDataRestaurant
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ActivityLiveDataApiMainBinding

class LiveDataApiMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLiveDataApiMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLiveDataApiMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val mainViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(LiveDataApiViewModel::class.java)
        mainViewModel.restaurant.observe(this) { restaurant ->
            setRestaurantData(restaurant)
        }

        val layoutManager = LinearLayoutManager(this)
        binding.ldrvReview.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.ldrvReview.addItemDecoration(itemDecoration)

        mainViewModel.listReview.observe(this) { consumerReviews ->
            setReviewData(consumerReviews)
        }
        mainViewModel.isLoading.observe(this) {
            showLoading(it)
        }

        binding.ldbtnSend.setOnClickListener { view ->
            mainViewModel.postReview(binding.ldedReview.text.toString())
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun setRestaurantData(restaurant: LiveDataRestaurant) {
        binding.ldtvTitle.text = restaurant.name
        binding.ldtvDescription.text = restaurant.description
        Glide.with(this)
            .load("https://restaurant-api.dicoding.dev/images/large/${restaurant.pictureId}")
            .into(binding.ldivPicture)
    }

    private fun setReviewData(consumerReviews: List<LiveDataCustomerReviewsItem>) {
        val adapter = LiveDataListReviewAdapter()
        adapter.submitList(consumerReviews)
        binding.ldrvReview.adapter = adapter
        binding.ldedReview.setText("")
    }

    private fun showLoading(isLoading: Boolean) {
        binding.ldprogressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}