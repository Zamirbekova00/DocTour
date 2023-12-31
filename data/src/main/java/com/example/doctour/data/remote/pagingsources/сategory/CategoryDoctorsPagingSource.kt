package com.example.doctour.data.remote.pagingsources.сategory

import com.example.doctour.data.base.BasePagingSource
import com.example.doctour.data.model.SpecialtyDt
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.domain.model.Specialty

class CategoryDoctorsPagingSource(
    private val doctourApiService: DoctourApiService,
    private val search:String,
    private val pageSize:Int
):BasePagingSource <SpecialtyDt,Specialty>({page ->
    doctourApiService.getSpeciality(search, page,pageSize)
})