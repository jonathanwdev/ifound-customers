package com.ifound.domain.repository
import com.ifound.domain.models.Coordinates
import kotlinx.coroutines.flow.Flow

interface LocalLocationRepository {
    suspend fun getCurrentLocation(): Result<Coordinates>
}