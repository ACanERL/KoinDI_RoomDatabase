package com.example.koindi_roomdatabase

import android.app.Application
import com.example.koindi_roomdatabase.di.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp:Application() {
    override fun onCreate() {
        super.onCreate()
         startKoin {
             androidContext(this@MyApp)
             modules(databaseModule)
         }
    }
}