package com.ifound.common.di

import com.ifound.common.utils.DefaultDispatcherQualifier
import com.ifound.common.utils.IODispatcherQualifier
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module



val dispatchersModule = module {
    single<CoroutineDispatcher>(qualifier = IODispatcherQualifier) {
        Dispatchers.IO
    }
    single<CoroutineDispatcher>(qualifier = DefaultDispatcherQualifier) {
        Dispatchers.Default
    }
}