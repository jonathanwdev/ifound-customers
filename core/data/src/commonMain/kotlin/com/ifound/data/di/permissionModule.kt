package com.ifound.data.di

import dev.icerock.moko.permissions.PermissionsController
import dev.icerock.moko.permissions.compose.PermissionsControllerFactory
import org.koin.core.module.Module
import org.koin.dsl.module

internal expect  val permissionFactoryModule: Module

val permissionModules = module {
    includes(permissionFactoryModule)
    single <PermissionsController> {
        val factory = get<PermissionsControllerFactory>()
        factory.createPermissionsController()
    }
}