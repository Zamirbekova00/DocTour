package com.example.doctour.presentation.ui.fragments.authAndReg.signIn

import android.annotation.SuppressLint
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentSignInBinding
import com.example.doctour.di.UserPreferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.google.i18n.phonenumbers.PhoneNumberUtil

@AndroidEntryPoint
class SignInFragment : BaseFragment<FragmentSignInBinding, SignInViewModel>(
    R.layout.fragment_sign_in
) {
    @Inject
    lateinit var userPreferences: UserPreferences

    override val binding: FragmentSignInBinding by viewBinding(FragmentSignInBinding::bind)
    override val viewModel: SignInViewModel by viewModels()

    private var isPasswordVisible: Boolean = false

    override fun initListeners() {
        super.initListeners()
        binding.btnLogIn.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
        binding.eye.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            togglePasswordVisibility()
        }
        binding.tvForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.forgotPasswordFragment)
        }
    }

    private fun togglePasswordVisibility() {
        if (isPasswordVisible) {
            binding.etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            binding.eye.setImageResource(R.drawable.ic_close_eye)
        } else {
            binding.etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            binding.eye.setImageResource(R.drawable.layer_list_remove_eye)
        }
        binding.etPassword.text?.let { binding.etPassword.setSelection(it.length) }
    }

    @SuppressLint("SetTextI18n")
    private fun numberCode() {
        val phoneNumberUtil = PhoneNumberUtil.getInstance()
        val defaultCountryNumber = phoneNumberUtil.getCountryCodeForRegion("KG")
        binding.etNumber.setText("+$defaultCountryNumber")
    }

    override fun initSubscribers() {
        viewModel.signInState.spectateUiState (success = {
            userPreferences.isAuthenticated = true
            userPreferences.userID = it.id
            userPreferences.username = it.username
            userPreferences.password = binding.etPassword.text.toString()
            initListeners()
        }, error = {
            Toast.makeText(requireContext(), getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show()
        })
    }
}