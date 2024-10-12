package com.example.myapplication.retrofit.data.response

import com.google.gson.annotations.SerializedName

data class RetrofitRestaurantResponse(

	@field:SerializedName("restaurant")
	val restaurant: RetrofitRestaurant,

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("message")
	val message: String
)

data class RetrofitPostReviewResponse(

	@field:SerializedName("customerReviews")
	val customerReviews: List<RetrofitCustomerReviewsItem>,

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("message")
	val message: String
)

data class RetrofitCustomerReviewsItem(

	@field:SerializedName("date")
	val date: String,

	@field:SerializedName("review")
	val review: String,

	@field:SerializedName("name")
	val name: String
)

data class RetrofitRestaurant(

	@field:SerializedName("customerReviews")
	val customerReviews: List<RetrofitCustomerReviewsItem>,

	@field:SerializedName("pictureId")
	val pictureId: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("rating")
	val rating: Any,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("id")
	val id: String
)
