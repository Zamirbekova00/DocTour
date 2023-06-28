package com.example.doctour.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.City
import com.example.doctour.domain.model.Clinics
import com.example.doctour.domain.model.Doctor
import com.example.doctour.domain.model.Review
import com.example.doctour.domain.model.Speciality

data class DoctorUi(
    override val id: Int,
    val average_rating: String,
    val clinic: List<ClinicsUi>,
    val experience: Int,
    val full_name: String,
    val num_reviews:String,
    val photo: String,
    val price: Int,
    val specialties: List<SpecialityUi>,
    val summary: String,
    val instagram :String,
    val doctor_reviews:List<ReviewUi>
) : IBaseDiffModel<Int>

fun Doctor.toDoctorUi() = DoctorUi(
    id,
    average_rating,
    clinic.map { it.toClinicsUi() },
    experience,
    full_name,
    num_reviews,
    photo,
    price,
    specialties.map { it.toSpecialityUi() },
    summary,
    instagram,
    doctor_reviews.map { it.toReviewUi() }
)

data class ReviewUi(
    val doctor: Int,
    override val id: Int,
    val stars: Int,
    val text: String
):IBaseDiffModel<Int>

fun Review.toReviewUi() = ReviewUi(
    id=id, text=text, stars=stars, doctor=doctor
)

data class SpecialityUi(
    override val id: Int,
    val name: String
):IBaseDiffModel<Int>

fun Speciality.toSpecialityUi() = SpecialityUi(
    id, name
)

data class ClinicsUi(
    val address: String,
    val contacts1: Long,
    val contacts2: Long,
    val descriptions: String,
    val ending_working_day: String,
    override val id: Int,
    val link_2gis: String,
    val link_clinic: String,
    val photo: String,
    val starting_working_day: String,
    val title: String,
    val weekday: String,
    val weekend: String
):IBaseDiffModel<Int>

fun Clinics.toClinicsUi() = ClinicsUi(
    id=id,
    photo=photo,
    link_clinic=link_clinic,
    link_2gis=link_2gis,
    descriptions=descriptions,
    starting_working_day=starting_working_day,
    ending_working_day=ending_working_day,
    address=address,
    contacts1=contacts1,
    contacts2=contacts2,
    weekday=weekday,
    weekend=weekend,
    title=title
)

data class CityUi(
    val id: Int,
    val name: String
)

fun City.toCityUi() = CityUi(
    id, name
)