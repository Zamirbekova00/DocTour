package com.example.doctour.presentation.ui.fragments.main.profileimport com.example.doctour.base.BaseViewModelimport dagger.hilt.android.lifecycle.HiltViewModelimport kotlinx.coroutines.flow.asStateFlowimport javax.inject.Inject@HiltViewModelclass ProfileViewModel @Inject constructor(    // private val userRepository: UserRepository) : BaseViewModel() {    private val _accountDeletionState = mutableUiStateFlow<Unit>()    val accountDeletionState = _accountDeletionState.asStateFlow()    // fun deleteAccount() = userRepository.deleteAccount().gatherRequest(_accountDeletionState)}