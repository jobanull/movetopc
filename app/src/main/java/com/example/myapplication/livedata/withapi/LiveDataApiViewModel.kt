package com.example.myapplication.livedata.withapi

import LiveDataCustomerReviewsItem
import LiveDataPostReviewResponse
import LiveDataRestaurant
import LiveDataRestaurantResponse
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LiveDataApiViewModel  : ViewModel() {

    private val _restaurant = MutableLiveData<LiveDataRestaurant>()
    val restaurant: LiveData<LiveDataRestaurant> = _restaurant

    private val _listReview = MutableLiveData<List<LiveDataCustomerReviewsItem>>()
    val listReview: LiveData<List<LiveDataCustomerReviewsItem>> = _listReview

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    companion object{
        private const val TAG = "MainViewModel"
        private const val RESTAURANT_ID = "uewq1zg2zlskfw1e867"
    }

    init{
        findRestaurant()
    }

    private fun findRestaurant() {
        _isLoading.value = true
        val client = LiveDataApiConfig.getApiService().getRestaurant(RESTAURANT_ID)
        client.enqueue(object : Callback<LiveDataRestaurantResponse> {
            override fun onResponse(
                call: Call<LiveDataRestaurantResponse>,
                response: Response<LiveDataRestaurantResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _restaurant.value = response.body()?.restaurant
                    _listReview.value = response.body()?.restaurant?.customerReviews
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<LiveDataRestaurantResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun postReview(review: String) {
        _isLoading.value = true
        val client = LiveDataApiConfig.getApiService().postReview(RESTAURANT_ID, "Dicodings", review)
        client.enqueue(object : Callback<LiveDataPostReviewResponse> {
            override fun onResponse(call: Call<LiveDataPostReviewResponse>, response: Response<LiveDataPostReviewResponse>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _listReview.value = response.body()?.customerReviews
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<LiveDataPostReviewResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }
}