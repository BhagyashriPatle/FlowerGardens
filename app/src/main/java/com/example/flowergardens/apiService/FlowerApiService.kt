package com.example.flowergardens.apiService

import com.example.flowergardens.model.Flower
import retrofit2.http.GET

interface FlowerApiService {
    @GET("2e5d0785-8920-4333-a225-c4857dd4d2ef")
    suspend fun getFlowers(): List<Flower>
}
