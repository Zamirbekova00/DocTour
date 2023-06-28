package com.example.doctour.presentation.ui.fragments.main.password

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentChangePasswordBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class ChangePasswordFragment : BaseFragment<FragmentChangePasswordBinding, PasswordViewModel>(
    R.layout.fragment_change_password
){

    override val binding: FragmentChangePasswordBinding by viewBinding(FragmentChangePasswordBinding::bind)
    override val viewModel: PasswordViewModel by viewModels<PasswordViewModel>()

    override fun initListeners() {
        super.initListeners()
        binding.tvArrowBack.setOnClickListener {
            findNavController().navigateUp()
        }
        clickers()
    }

    private fun clickers() {
        with(binding) {
            btnNext.setOnClickListener {
                if (etCurrentPassword.text!!.isEmpty() || etNewPassword.text!!.isEmpty() || etRepeatNewPassword.text!!.isEmpty()) {
                    Toast.makeText(requireContext(), getString(R.string.line_), Toast.LENGTH_SHORT).show()
                }
                if (etCurrentPassword.text != etNewPassword.text) {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.change_password),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                when (etNewPassword.text) {
                    etRepeatNewPassword -> {
                        // TODO: change password in server
                    }
                }
            }
        }
    }
}