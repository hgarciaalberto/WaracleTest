package com.ahgitdevelopment.waracletest.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ahgitdevelopment.waracletest.testutils.LIST_WITHOUT_DUPLICATES_AND_SORTED
import com.ahgitdevelopment.waracletest.testutils.MainCoroutineScopeRule
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainFragmentViewModelTest {

    @get:Rule
    val coroutineScope = MainCoroutineScopeRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var serviceApi: CakeServiceTd

    lateinit var SUT: MainFragmentViewModel

    @Before
    fun setup() {
        serviceApi = CakeServiceTd()
        SUT = MainFragmentViewModel()
    }


    @Test
    fun getCakeList_ValidResponse_CheckFinalList() = runBlocking {
        // Arrange
        serviceApi.response = Response.VALID

        // Act
        SUT.getCakeList(serviceApi)

        // Assert
        Truth.assertThat(SUT.cakeList.value).isEqualTo(LIST_WITHOUT_DUPLICATES_AND_SORTED)
    }

    @Test
    fun getCakeList_ExceptionResponse_ShowError() = runBlocking {
        // Arrange
        serviceApi.response = Response.ERROR

        // Act
        SUT.getCakeList(serviceApi)

        // Assert
        Truth.assertThat(SUT.showError.value).isTrue()
    }

    // region constants
    // endregion constants

    // region helper fields
    // endregion helper fields


    // region helper methods
    // endregion helper methods

    // region helper classes 
    // endregion helper classes
}