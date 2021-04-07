package com.markoapps.testserviceproject.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [AppEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ServiceProjectDatabase : RoomDatabase() {

  companion object {

    private const val DATABASE_NAME = "serviceProject.db"

    private var instance: ServiceProjectDatabase? = null

    private fun create(context: Context): ServiceProjectDatabase =
        Room.databaseBuilder(context, ServiceProjectDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()


    fun getInstance(context: Context): ServiceProjectDatabase =
        (instance ?: create(context)).also { instance = it }
  }

  abstract fun documentDao(): AppsDao

}