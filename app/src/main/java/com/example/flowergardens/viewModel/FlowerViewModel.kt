package com.example.flowergardens.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flowergardens.apiService.RetrofitInstance
import com.example.flowergardens.model.Flower
import kotlinx.coroutines.launch
import retrofit2.HttpException

class FlowerViewModel : ViewModel() {
    private val _flowers = MutableLiveData<List<Flower>>()
    val flowers: LiveData<List<Flower>> get() = _flowers

    init {
        fetchFlowers()
    }

    fun fetchFlowers() {
        viewModelScope.launch {
            try {
                _flowers.value = RetrofitInstance.api.getFlowers()
            } catch (e: HttpException) {
                // Handle HTTP error
                Log.e("FlowerViewModel", "HttpException: ${e.message()}")
            } catch (e: Exception) {
                // Handle other errors
                Log.e("FlowerViewModel", "Exception: ${e.message}")
            }
        }
    }
}

