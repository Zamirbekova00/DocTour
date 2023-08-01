package com.example.doctour.data.remote.pagingsources

import com.example.doctour.data.base.BasePagingSource
import com.example.doctour.data.model.DoctorDt
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.domain.model.Doctor

class DoctourPagingSource(
    private val doctourApiService: DoctourApiService,
   private val pageSize:Int,
    private val specialties: String?,
    private val categoryService: String?,
    private val city: String?,
    private val  search: String?,
    private val ordering: String?
) : BasePagingSource<DoctorDt,Doctor>(
    {page ->
        doctourApiService.getDoctors(page,pageSize,search, ordering, city, categoryService, specialties)
    }
)