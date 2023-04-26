package com.example.rkmovies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rkmovies.databinding.TvShowItemBinding
import com.example.rkmovies.models.TvShowItem

class TvShowAdapter(val onItemClick : (tvShow : TvShowItem) -> Unit): RecyclerView.Adapter<TvShowAdapter.MyViewHolder>() {



    inner class MyViewHolder(val binding: TvShowItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffcallback = object : DiffUtil.ItemCallback<TvShowItem>(){
        override fun areItemsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return newItem == oldItem
        }

    }

    private val differ = AsyncListDiffer(this,diffcallback)
    var tvShows:List<TvShowItem>
    get() = differ.currentList
    set(value) {
        differ.submitList(value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(TvShowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return tvShows.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTvShow = tvShows[position]

        holder.binding.apply {
            textv.text = currentTvShow.name
            imgv.load(currentTvShow.image.original){
                crossfade(true)
                crossfade(1000)
            }
            root.setOnClickListener {
                onItemClick(currentTvShow)
            }
        }
    }
}