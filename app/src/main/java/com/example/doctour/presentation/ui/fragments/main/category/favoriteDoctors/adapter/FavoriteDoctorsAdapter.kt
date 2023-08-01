package com.example.doctour.presentation.ui.fragments.main.category.favoriteDoctors.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemDoctorsInfoBinding
import com.example.doctour.presentation.extensions.loadImage
import com.example.doctour.presentation.model.DoctorUI
import com.example.doctour.presentation.model.FavoriteDoctorUI

class FavoriteDoctorsAdapter(
    private val onClick:(FavoriteDoctorUI)-> Unit,
    private val onLongClick:(FavoriteDoctorUI)->Unit
) : PagingDataAdapter< FavoriteDoctorUI,FavoriteDoctorsAdapter.FavoriteDoctorsViewHolder>(
    DFUtilFavDoctor()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteDoctorsViewHolder {
        return FavoriteDoctorsViewHolder(
            ItemDoctorsInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))}

    override fun onBindViewHolder(holder: FavoriteDoctorsViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class FavoriteDoctorsViewHolder(
        private val binding: ItemDoctorsInfoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(doctor: FavoriteDoctorUI) {
//            doctor.photo?.let { binding.ivDoctorAvatar.loadImage(it) }
//            binding.tvDoctorName.text = doctor.full_name
//            binding.tvWorkExperience.text = doctor.experience.toString()
//            binding.tvWorkSpeciality.text = doctor.specialties.toString()
//            binding.tvWorkClinic.text = doctor.clinic.toString()
//            binding.tvRecommendation.text = "${doctor.num_reviews} рекомендаций"
//            binding.tvPoints.text =  doctor.average_rating.toString()
//            binding.tvSumma.text = doctor.num_reviews.toString()

            itemView.setOnClickListener {
                onClick(doctor)
            }
            itemView.setOnLongClickListener {
                onLongClick(doctor)
                return@setOnLongClickListener false
            }
        }

    }
}
private class DFUtilFavDoctor : DiffUtil.ItemCallback<FavoriteDoctorUI>() {
    override fun areItemsTheSame(oldItem: FavoriteDoctorUI, newItem: FavoriteDoctorUI): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: FavoriteDoctorUI, newItem: FavoriteDoctorUI): Boolean {
        return oldItem == newItem
    }
}