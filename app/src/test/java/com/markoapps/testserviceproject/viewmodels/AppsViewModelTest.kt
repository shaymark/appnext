package com.markoapps.testserviceproject.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.markoapps.testserviceproject.repositories.AppsRepository
import com.markoapps.testserviceproject.model.AppModel
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito

import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class AppsViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var appsRepository: AppsRepository

    lateinit var viewModel: AppsViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.`when`(appsRepository.apps).thenReturn(flow { emit(listOf(AppModel.EMPTY)) })
        viewModel = AppsViewModel(appsRepository)
    }

    @Test
    fun addition_isCorrect() {
        Assert.assertEquals(4, 2 + 2)
    }

//    @Test
//    fun test_addDocument(){
//        runBlocking {
//
//            val document = AppModel("","",1,"")
//
//            viewModel.addDocument(document)
//
//            verify(appsRepository).addApp(document)
//        }
//
//    }
//
//    @Test
//    fun test_removeDocument(){
//        runBlocking {
//
//            val document = AppModel("","",1,"")
//
//            viewModel.removeDocument(document)
//
//            verify(appsRepository).removeDocument(document)
//        }
//
//    }

}