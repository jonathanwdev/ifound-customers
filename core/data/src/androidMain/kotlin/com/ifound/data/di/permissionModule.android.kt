package com.ifound.data.di

import android.app.Application
import dev.icerock.moko.geo.LocationTracker
import dev.icerock.moko.permissions.PermissionsController
import dev.icerock.moko.permissions.compose.PermissionsControllerFactory
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


actual val permissionFactoryModule = module {
    single<PermissionsControllerFactory> {
        configurePermissionController(application = androidApplication())
    }


}

 private fun configurePermissionController(application: Application): PermissionsControllerFactory {
    val factory = PermissionsControllerFactory {
        PermissionsController(application)
    }
    return factory
}

