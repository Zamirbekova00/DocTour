package com.example.doctour.domain.model

data class SubService(
    val id:Int,
    val name:String,
    val price:Int,
    val num_clinic:String,
    val service:Int,
    val clinic:List<Clinics>
)