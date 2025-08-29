package com.ifound.data.di

import dev.icerock.moko.geo.LocationTracker
import org.koin.dsl.module

internal actual val locationPlatformModule = module {
    single<LocationTracker> {
        LocationTracker(
            permissionsController = get()
        )
    }
}