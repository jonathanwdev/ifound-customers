package com.ifound.data.di

import com.ifound.data.local.repository.LocalLocationRepositoryImpl
import com.ifound.domain.repository.LocalLocationRepository
import org.koin.core.module.Module
import org.koin.dsl.module

internal expect  val locationPlatformModule: Module



val locationModules = module {
    includes(locationPlatformModule)

    single<LocalLocationRepository> {
        LocalLocationRepositoryImpl(locationTracker = get())
    }
}