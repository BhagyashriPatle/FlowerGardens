package com.example.flowergardens

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flowergardens.adapter.FlowerAdapter
import com.example.flowergardens.viewModel.FlowerViewModel
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.flowergardens.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: FlowerViewModel
    private lateinit var flowerAdapter: FlowerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        flowerAdapter = FlowerAdapter { flower ->
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("flower", flower)
            startActivity(intent)
        }
        binding.rvFlowerList.layoutManager = LinearLayoutManager(this)
        binding.rvFlowerList.adapter = flowerAdapter
        viewModel = ViewModelProvider(this).get(FlowerViewModel::class.java)

        viewModel.flowers.observe(this, Observer {
            flowerAdapter.submitList(it)
        })

        viewModel.fetchFlowers()
    }
}

