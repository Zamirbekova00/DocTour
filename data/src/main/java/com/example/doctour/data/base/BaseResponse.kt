package com.example.doctour.data.base

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next:String?,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<T>
)
