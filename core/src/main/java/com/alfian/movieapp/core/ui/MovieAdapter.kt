package com.alfian.movieapp.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alfian.movieapp.core.Constants.IMG_URL
import com.alfian.movieapp.core.R
import com.alfian.movieapp.core.domain.model.Movie
import com.alfian.movieapp.core.databinding.ItemListMovieBinding
import com.bumptech.glide.Glide
import java.util.ArrayList

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {

    private var listData = ArrayList<Movie>()
    var onItemClick: ((Movie) -> Unit)? = null

    fun setData(newListData: List<Movie>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_movie, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListMovieBinding.bind(itemView)
        fun bind(data: Movie) {
            with(binding) {

                // Nanti aja
                Glide.with(itemView.context)
                    .load(IMG_URL+data.posterPath)
                    .into(imgPoster)

                tvTitle.text = data.title
                tvRelease.text = data.releaseDate
                tvRating.text = data.voteAverage.toString()
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}