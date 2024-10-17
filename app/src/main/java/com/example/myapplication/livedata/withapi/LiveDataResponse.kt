
import com.google.gson.annotations.SerializedName

data class LiveDataRestaurantResponse(

    @field:SerializedName("restaurant")
    val restaurant: LiveDataRestaurant,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)

data class LiveDataPostReviewResponse(

    @field:SerializedName("customerReviews")
    val customerReviews: List<LiveDataCustomerReviewsItem>,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)

data class LiveDataCustomerReviewsItem(

    @field:SerializedName("date")
    val date: String,

    @field:SerializedName("review")
    val review: String,

    @field:SerializedName("name")
    val name: String
)

data class LiveDataRestaurant(

    @field:SerializedName("customerReviews")
    val customerReviews: List<LiveDataCustomerReviewsItem>,

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
