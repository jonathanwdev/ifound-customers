package com.ifound.data.di

import com.ifound.common.utils.IODispatcherQualifier
import com.ifound.data.network.dataSource.AuthRemoteDataSource
import com.ifound.data.network.dataSource.AuthRemoteDataSourceImpl
import com.ifound.data.network.repository.AuthRepositoryImpl
import com.ifound.domain.repository.AuthRepository
import io.ktor.client.HttpClient
import org.koin.dsl.module


val dataModule = module {
    single<HttpClient> { createHttpClient() }
    single<AuthRemoteDataSource> { AuthRemoteDataSourceImpl(get()) }
    single<AuthRepository> {
        AuthRepositoryImpl(
            get(),
            get(qualifier = IODispatcherQualifier)
        )
    }
}