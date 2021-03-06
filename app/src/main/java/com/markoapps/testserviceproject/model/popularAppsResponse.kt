package com.markoapps.testserviceproject.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PopularAppsResponse(
        @SerializedName("most_popular_apps") val popularApps: List<AppModel>,
): Serializable