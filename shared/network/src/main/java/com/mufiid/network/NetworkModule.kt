package com.mufiid.network

import org.koin.dsl.module

object NetworkModule {
    fun modules() = module {
        factory { RetrofitBuilder() }
    }
}