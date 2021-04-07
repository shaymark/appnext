package com.markoapps.testserviceproject.services

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.markoapps.testserviceproject.di.Provider
import kotlinx.coroutines.runBlocking
import java.lang.Exception



class PopularAppsWorker(val ctx : Context, params : WorkerParameters) : Worker(ctx, params)
{
    private val appsRepository = Provider.documentRepository

    override fun doWork(): Result
    {
        return runBlocking {
            try {
                appsRepository.updateApps()
                Result.success()
            } catch (e: Exception) {
                Result.failure()
            }
        }
    }
}