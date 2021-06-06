package com.alfian.movieapp

import android.app.Application
import com.alfian.movieapp.core.di.databaseModule
import com.alfian.movieapp.core.di.networkModule
import com.alfian.movieapp.core.di.repositoryModule
import com.alfian.movieapp.di.useCaseModule
import com.alfian.movieapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }


}