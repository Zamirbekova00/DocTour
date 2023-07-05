package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.DoctorDetail

data class DoctorDetailDt(
    val id: String,
    val doctor_reviews: List<ReviewDt> ?= emptyList(),
    val average_rating: String?,
    val num_reviews: String?,
    val specialties: List<SpecialtyDt>?= emptyList(),
    val clinic: List<ClinicDt>,
    val category_services: List<ServiceDt>?= emptyList(),
    val city: CityDt,
    val doctor_experience: List<ExperienceDt>?= emptyList(),
    val doctor_certificates: List<CertificatesDt>?= emptyList(),
    val doctor_education: List<EducationDt>?= emptyList(),
    val doctor_specialization: List<SpecializationDt>?= emptyList(),
    val photo: String?,
    val full_name: String?,
    val experience: Int?,
    val price: Int?,
    val summary: String?,
    val phone: String?,
    val instagram:String?
) : DataMapper<DoctorDetail> {
    override fun mapToDomain() = DoctorDetail(
        id,
        doctor_reviews?.map { it.mapToDomain() },
        average_rating,
        num_reviews,
        specialties?.map { it.mapToDomain() },
        clinic.map { it.mapToDomain() },
        category_services?.map { it.mapToDomain() },
        city.mapToDomain(),
        doctor_experience?.map { it.mapToDomain() },
        doctor_certificates?.map { it.mapToDomain() },
        doctor_education?.map { it.mapToDomain() },
        doctor_specialization?.map { it.mapToDomain() },
        photo,
        full_name,
        experience,
        summary,
        price,
        phone,
        instagram
    )
}
