package com.markoapps.testserviceproject.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface AppsDao {

  @Insert(onConflict = REPLACE)
  suspend fun addApp(app: AppEntity)

  @Insert(onConflict = REPLACE)
  fun addMultipleDocuments(app: List<AppEntity>)

  @Query("SELECT * FROM apps")
  fun getApps(): Flow<List<AppEntity>>

  @Query("SELECT * FROM apps WHERE package_name=:packageName")
  suspend fun getApp(packageName: String): AppEntity

  @Delete
  suspend fun removeDocument(app: AppEntity)
}
