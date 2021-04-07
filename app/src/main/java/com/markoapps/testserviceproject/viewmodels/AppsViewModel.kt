package com.markoapps.testserviceproject.viewmodels

import androidx.lifecycle.*


import com.markoapps.testserviceproject.repositories.AppsRepository
import com.markoapps.testserviceproject.model.AppModel
import kotlinx.coroutines.launch


class AppsViewModel(private val appsRepository: AppsRepository): ViewModel() {

    val appsLiveData: LiveData<List<AppModel>> = appsRepository
        .apps
        .asLiveData(viewModelScope.coroutineContext)

    init {
        viewModelScope.launch {
            //appsRepository.updateApps()
        }
    }

}