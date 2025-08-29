package com.example.ifound.di

import com.ifound.common.di.dispatchersModule
import com.ifound.data.di.dataModule
import com.ifound.data.di.locationModules
import com.ifound.data.di.permissionModules
import com.ifound.recover_password.di.featureRecoverPasswordModule
import com.ifound.sign.di.featureSignModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin


fun initializeKoin(
    config: (KoinApplication.() -> Unit)? = null
) {
    startKoin {
        config?.invoke(this)
        modules(
            sharedModule,
            dispatchersModule,
            permissionModules,
            locationModules,
            dataModule,
            featureSignModule,
            featureRecoverPasswordModule
        )
    }
}