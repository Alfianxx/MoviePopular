package com.alfian.movieapp2.favorite

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModul = module {
    viewModel { FavoriteViewModel(get()) }
}
