package com.example.features.login

import com.example.core.db.repository.product.ProductRepositoryImpl
import com.example.core.db.repository.user.UserRepositoryImpl
import com.example.core.network.LoginRequest
import com.example.features.login.model.LoginResponse
import com.example.features.login.repository.LoginRepositoryImpl
import com.example.features.login.viewmodel.LoginViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import kotlin.test.Test
import kotlin.test.assertEquals

// build.gradle (app)
// testImplementation "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3"
// testImplementation "io.mockk:mockk:1.13.8"
// testImplementation "junit:junit:4.13.2" or junit-jupiter for JUnit5

@OptIn(ExperimentalCoroutinesApi::class)
class LoginViewModelTest {

    private val repo: LoginRepositoryImpl = mockk()
    private val userRepo: UserRepositoryImpl = mockk()
    private val productRepo: ProductRepositoryImpl = mockk()
    private lateinit var viewModel: LoginViewModel

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = LoginViewModel(repo,userRepo,productRepo)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `doLogin should return success response`() = runTest {
        // Given
        val fakeResponse = LoginResponse.demoResponseSuccess()
        coEvery { repo.login(any()) } returns fakeResponse

        var result: LoginResponse? = null

        // When
        viewModel.doLogin("user", "pass") { response ->
            result = response
        }
        // Advance until all coroutines complete
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertEquals(true, result?.isSuccess)
        //assertEquals("abc123", result?.token)

        coVerify { repo.login(LoginRequest("user", "pass")) }
    }

    @Test
    fun `doLogin should return fail response`() = runTest {
        // Given
        val fakeResponse = LoginResponse.demoResponseFail()
        coEvery { repo.login(any()) } returns fakeResponse

        var result: LoginResponse? = null

        // When
        viewModel.doLogin("user", "pass") { response ->
            result = response
        }
        // Advance until all coroutines complete
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertEquals(false, result?.isSuccess)
        //assertEquals("abc123", result?.token)

        coVerify { repo.login(LoginRequest("user", "pass")) }
    }

}
