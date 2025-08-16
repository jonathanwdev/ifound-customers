package com.example.ifound

import android.app.Application
import com.example.ifound.di.initializeKoin
import org.koin.android.ext.koin.androidContext

class IfoundApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initializeKoin(
            config = {
                androidContext(this@IfoundApplication)
            }
        )
    }
}