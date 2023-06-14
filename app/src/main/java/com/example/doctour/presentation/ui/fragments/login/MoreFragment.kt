package com.example.doctour.presentation.ui.fragments.login

import android.view.View
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentMoreBinding
import com.example.doctour.presentation.base.BaseFragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MoreFragment : BaseFragment<FragmentMoreBinding,LoginViewModel>(
    R.layout.fragment_more
) {

    override val binding: FragmentMoreBinding by viewBinding(FragmentMoreBinding::bind)
    override val viewModel: LoginViewModel by viewModels<LoginViewModel>()

    override fun initListeners() {
        super.initListeners()
        setBottomSheet()
        clickers()
    }

    private fun clickers() {
        with(binding) {
            btnProfile.setOnClickListener {
                findNavController().navigate(R.id.fillProfileFragment)
            }
        }
    }

    private fun setBottomSheet() {
        binding.btnExit.setOnClickListener {
            val view: View = layoutInflater.inflate(R.layout.exit_bottom_sheet, null)
            val dialog = BottomSheetDialog(requireActivity())
            dialog.setContentView(view)
            val btnDismiss = dialog.findViewById<Button>(R.id.btn_back)
            val btnLeave = dialog.findViewById<Button>(R.id.btn_confirm)

            btnDismiss?.setOnClickListener {
                dialog.dismiss()
            }
            btnLeave?.setOnClickListener {

            }
            dialog.show()
        }
    }
}