package com.ifound.data.local.repository

import com.ifound.domain.models.Coordinates
import com.ifound.domain.repository.LocalLocationRepository
import dev.icerock.moko.geo.LocationTracker
import kotlinx.coroutines.flow.first

class LocalLocationRepositoryImpl(
    private val locationTracker: LocationTracker,
) : LocalLocationRepository {

    override suspend fun getCurrentLocation(): Result<Coordinates> {
        return runCatching {
            val location = locationTracker.getLocationsFlow().first()
            Coordinates(location.latitude, location.longitude)
        }.onFailure {
            it.printStackTrace()
        }

    }
}