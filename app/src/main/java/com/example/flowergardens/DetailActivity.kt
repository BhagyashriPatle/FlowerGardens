package com.example.flowergardens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.flowergardens.databinding.ActivityDetailBinding
import com.example.flowergardens.model.Flower

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this,R.layout.activity_detail)

        val flower = intent.getSerializableExtra("flower") as? Flower

        flower?.let {
            binding.tvFlowerName.text = it.name
            binding.tvFlowerDescription.text = it.description
            Glide.with(this).load(it.imageUrl).into(binding.ivFlowerImage)
        }
        binding.back.setOnClickListener {
            finish()
        }
    }
}
