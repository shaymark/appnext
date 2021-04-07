package com.markoapps.testserviceproject.network


import com.markoapps.testserviceproject.model.PopularAppsResponse
import retrofit2.http.GET

interface NetworkApi {
    @GET("3656a2ce-37a9-11eb-9cc1-b51d3145a984")
    suspend fun getApps() : PopularAppsResponse

}