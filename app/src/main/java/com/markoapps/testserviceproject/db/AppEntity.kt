package com.markoapps.testserviceproject.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "apps")
data class AppEntity(
    @PrimaryKey @ColumnInfo(name = "package_name") val packageName: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "rating") val rating: Float,
    @ColumnInfo(name = "developer") val developer: String,
    @ColumnInfo(name = "what_is_new") val whatIsNew: String,
    @ColumnInfo(name = "icon") val icon: String,
)
