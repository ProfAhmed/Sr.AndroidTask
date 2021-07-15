package ahmedpro.com.cuerrencyconverter.data.api

import ahmedpro.com.cuerrencyconverter.data.models.LatestModel
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiService {
    @GET("api/latest")
    suspend fun latest(@QueryMap param: HashMap<String, String>): LatestModel

//    @GET("api/convert")
//    suspend fun convert(@QueryMap param: HashMap<String, String>): ConvertModel

}