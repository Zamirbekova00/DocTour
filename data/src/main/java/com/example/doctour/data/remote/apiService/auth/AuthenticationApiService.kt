package com.example.doctour.data.remote.apiService.auth

import com.example.doctour.data.remote.dto.SignInDto
import com.example.doctour.data.remote.dto.SignUpDto
import com.example.doctour.data.remote.dto.SignInResultDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApiService {

    @POST("users/register/")
    suspend fun signUp(@Body signUpDto: SignUpDto)

    @POST("users/login/")
    suspend fun login(@Body signInDto: SignInDto): SignInResultDto

}