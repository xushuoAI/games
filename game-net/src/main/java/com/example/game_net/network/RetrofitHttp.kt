package com.example.game_common.network

import com.example.game_net.utils.BASE_HTTP_URL
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers.io
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @ClassNameDescription
 *
 * @Author xushuo
 * @Date 2021-04-07
 * @Description
 */
class RetrofitHttp {

    companion object {
        val retrofit by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_HTTP_URL)
                .build()
        }

        fun getService() = retrofit.create(DataApi::class.java)


        fun <T> execute(observable: Observable<T>, observer: Observer<T>) {
            observable.subscribeOn(io())
                .unsubscribeOn(io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)

        }

    }

}