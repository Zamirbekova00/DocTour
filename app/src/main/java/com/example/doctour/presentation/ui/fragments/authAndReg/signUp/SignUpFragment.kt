package com.example.doctour.presentation.ui.fragments.authAndReg.signUp

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.data.viewmodels.UserRegisterVIewModel
import com.example.doctour.databinding.FragmentSignUpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class SignUpFragment : BaseFragment<FragmentSignUpBinding, SignUpViewModel>(
    R.layout.fragment_sign_up
) {

    override val binding: FragmentSignUpBinding by viewBinding(FragmentSignUpBinding::bind)
    override val viewModel: SignUpViewModel by viewModels<SignUpViewModel>()

    override fun initListeners() {
        super.initListeners()
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
    }

    fun initViewModel() {
        val viewModel = ViewModelProvider(this)[UserRegisterVIewModel::class.java]
    }

}