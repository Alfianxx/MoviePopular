package com.alfian.movieapp.di

import com.alfian.movieapp.core.domain.usecase.MovieInteractor
import com.alfian.movieapp.core.domain.usecase.MovieUseCase
import com.alfian.movieapp.detail.DetailMovieViewModel
import com.alfian.movieapp.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
}
