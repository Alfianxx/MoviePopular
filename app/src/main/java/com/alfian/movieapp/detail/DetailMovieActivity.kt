package com.alfian.movieapp.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.alfian.movieapp.core.Constants.IMG_URL
import com.alfian.movieapp.R
import com.alfian.movieapp.core.domain.model.Movie
import com.alfian.movieapp.databinding.ActivityDetailMovieBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {

    private val detailMovieViewModel: DetailMovieViewModel by viewModel()

    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        showDetailMovie(detailMovie)
    }

    private fun showDetailMovie(detailMovie: Movie?) {
        detailMovie?.let {
            supportActionBar?.title = detailMovie.title
            binding.content.tvDetailDescription.text = detailMovie.overview

            binding.content.tvRelease.text = getString(R.string.release, detailMovie.releaseDate)

            binding.content.tvRating.text = getString(R.string.rating, detailMovie.voteAverage)
            binding.content.tvPopularity.text = getString(R.string.popularity, detailMovie.popularity)
            Glide.with(this@DetailMovieActivity)
                .load(IMG_URL+detailMovie.posterPath)
                .into(binding.ivDetailImage)

            var statusFavorite = detailMovie.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailMovieViewModel.setFavoriteMovie(detailMovie, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

}
