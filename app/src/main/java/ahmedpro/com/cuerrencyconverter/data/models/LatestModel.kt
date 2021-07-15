package ahmedpro.com.cuerrencyconverter.data.models

import com.google.gson.annotations.SerializedName


data class LatestModel(
    @SerializedName("base")
    val base: String = "",
    @SerializedName("date")
    val date: String = "",
    @SerializedName("rates")
    val rates: Map<String, Double> = HashMap(),
    @SerializedName("success")
    val success: Boolean = false,
    @SerializedName("timestamp")
    val timestamp: Int = 0
)