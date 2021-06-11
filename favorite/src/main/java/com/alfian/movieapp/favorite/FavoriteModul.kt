package com.alfian.movieapp.favorite

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModul = module {
    viewModel { FavoriteViewModel(get()) }
}
