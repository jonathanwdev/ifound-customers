package com.ifound.data.di

import dev.icerock.moko.permissions.compose.PermissionsControllerFactory
import dev.icerock.moko.permissions.ios.PermissionsController
import org.koin.dsl.module


actual val permissionFactoryModule = module {
    single<PermissionsControllerFactory> {
        configurePermissionController()
    }
}

private fun configurePermissionController(): PermissionsControllerFactory {
    val factory = PermissionsControllerFactory {
        PermissionsController()
    }
    return factory
}