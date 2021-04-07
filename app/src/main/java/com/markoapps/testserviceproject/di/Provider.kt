package com.markoapps.testserviceproject.di

import android.content.Context
import com.markoapps.testserviceproject.repositories.AppsRepository
import com.markoapps.testserviceproject.db.ServiceProjectDatabase
import com.markoapps.testserviceproject.network.BaseRetrofit
import com.markoapps.testserviceproject.network.NetworkApi
import com.markoapps.testserviceproject.viewmodels.ServicesViewModelFactory

object Provider {

    lateinit var appContext: Context

    val db: ServiceProjectDatabase by lazy { ServiceProjectDatabase.getInstance(context = appContext) }

    val networkApi: NetworkApi by lazy {
        val retrofit = BaseRetrofit().get()
        retrofit.create(NetworkApi::class.java)
    }

    val documentRepository by lazy { AppsRepository(db.documentDao(), networkApi) }

    val servicesViewModelFactory by lazy { ServicesViewModelFactory(documentRepository) }

    fun inject(appContext: Context) {
        this.appContext = appContext
    }
}