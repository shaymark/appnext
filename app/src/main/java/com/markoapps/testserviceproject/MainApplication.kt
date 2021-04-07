package com.markoapps.testserviceproject

import android.app.Application
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.markoapps.testserviceproject.di.Provider
import com.markoapps.testserviceproject.services.PopularAppsWorker
import java.util.concurrent.TimeUnit

class MainApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        Provider.inject(this)

        val workManager = WorkManager.getInstance(applicationContext)
        workManager.enqueueUniquePeriodicWork(
            "workName",
            ExistingPeriodicWorkPolicy.REPLACE,
            PeriodicWorkRequest
                .Builder(PopularAppsWorker::class.java, 12, TimeUnit.HOURS)
                .build())
    }
}