package com.ifound.data.di

import com.ifound.data.network.dataSource.UserRemoteDataSource
import com.ifound.data.network.dataSource.UserRemoteDataSourceImpl
import com.ifound.data.network.repository.AuthRepositoryImpl
import com.ifound.domain.repository.AuthRepository
import io.ktor.client.HttpClient
import org.koin.dsl.module

val dataModule = module {
    single<HttpClient> { createHttpClient() }
    single<UserRemoteDataSource> { UserRemoteDataSourceImpl(get()) }
    single<AuthRepository> { AuthRepositoryImpl(get()) }
}