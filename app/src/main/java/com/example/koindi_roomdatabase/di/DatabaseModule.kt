package com.example.koindi_roomdatabase.di

import com.example.koindi_roomdatabase.repository.DatabaseRepository
import com.example.koindi_roomdatabase.viewmodel.DatabaseViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule= module {
    single { provideDatabase(androidContext()) }
    single { provideDao(get()) }
    factory { DatabaseRepository(get()) }
    viewModel(){DatabaseViewModel(get())}
}