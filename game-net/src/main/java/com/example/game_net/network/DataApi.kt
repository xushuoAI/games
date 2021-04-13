package com.example.game_common.network

import com.example.game_net.network.ResponseData
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * @ClassNameDescription
 *
 * @Author xushuo
 * @Date 2021-04-07
 * @Description
 */
interface DataApi {


    @GET("tophub/get")
    fun getHotDataList(@Query("type") type: String? = "zhihu"): Observable<ResponseData>

}