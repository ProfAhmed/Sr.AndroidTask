package ahmedpro.com.cuerrencyconverter.data.models


import com.google.gson.annotations.SerializedName

data class ConvertModel(
    @SerializedName("result")
    val result: Double = 0.0,
    @SerializedName("success")
    val success: Boolean = false
)