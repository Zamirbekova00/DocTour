package com.example.doctour.presentation.ui.fragments.login

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentLoginBinding
import com.example.doctour.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class LoginFragment : BaseFragment<FragmentLoginBinding,LoginViewModel>(
    R.layout.fragment_login
){

    override val binding: FragmentLoginBinding by viewBinding(FragmentLoginBinding::bind)
    override val viewModel: LoginViewModel by viewModels<LoginViewModel>()

}