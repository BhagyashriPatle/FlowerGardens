package com.example.flowergardens.adapter
// FlowerAdapter.kt
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flowergardens.R
import com.example.flowergardens.databinding.ItemFlowerBinding
import com.example.flowergardens.model.Flower

//data class Flower(val name: String, val description: String, val imageUrl: String)

class FlowerAdapter(private val onClick: (Flower) -> Unit) : RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder>() {

    private var flowers: List<Flower> = emptyList()

    fun submitList(flowers: List<Flower>) {
        this.flowers = flowers
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        val binding = ItemFlowerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FlowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        holder.bind(flowers[position])
    }

    override fun getItemCount(): Int = flowers.size

    inner class FlowerViewHolder(private val binding: ItemFlowerBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(flower: Flower) {
            binding.tvFlowerName.text = flower.name
            binding.tvFlowerDescription.text = flower.description
            Glide.with(binding.ivFlowerImage.context)
                .load(flower.imageUrl)
                .placeholder(R.drawable.app_icon)
                .into(binding.ivFlowerImage)

            binding.root.setOnClickListener {
                onClick(flower)
            }
        }
    }
}

