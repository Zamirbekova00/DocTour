package com.example.doctour.presentation.ui.fragments.authAndReg.signUpimport com.example.doctour.base.BaseViewModelimport com.example.doctour.data.repositories.AuthenticationRepositoryimport dagger.hilt.android.lifecycle.HiltViewModelimport kotlinx.coroutines.flow.asStateFlowimport javax.inject.Inject@HiltViewModelclass SignUpViewModel @Inject constructor(    private val authenticationRepository: AuthenticationRepository) : BaseViewModel() {    private val _signUpState = mutableUiStateFlow<Unit>()    val signUpState = _signUpState.asStateFlow()    fun signUp(        name: String,        username: String,        phone_number: String,        password: String,        password_again: String    ) = authenticationRepository.signUp(        name,        username,        phone_number,        password,        password_again    ).gatherRequest(_signUpState)}