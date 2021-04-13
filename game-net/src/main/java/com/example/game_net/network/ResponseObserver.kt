package com.example.game_net.network

import android.text.TextUtils
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * @ClassNameDescription
 *
 * @Author xushuo
 * @Date 2021-04-13
 * @Description
 */
abstract class ResponseObserver<Data> : Observer<Data> {
    private var mDisposable: Disposable? = null


    override fun onSubscribe(d: Disposable) {
        mDisposable = d
    }

    override fun onNext(value: Data) {
        onSuccess(value)
    }

    override fun onError(e: Throwable) {
        var msg = "网络请求失败"
        when (e) {
            is SocketTimeoutException -> {
                msg = "请求超时"
            }
            is ConnectException -> {
                msg = "连接服务器失败"
            }
            is UnknownHostException -> {
                msg = "网络连接异常"
            }
            is HttpException -> {
                msg = handleErrorResp(e)
            }

        }
        onFailure(msg)
    }

    override fun onComplete() {

    }

    /**
     * 网络请求成功回调
     *
     * @param result 返回数据
     */
    abstract fun onSuccess(result: Data?)


    /**
     * 网络请求失败回调
     *
     * @param msg 错误信息
     */
    abstract fun onFailure(msg: String)

    private fun handleErrorResp(e: HttpException): String {
        val statusCode = e.code()
        if (statusCode ==  NOT_LOGIN) {

            return "登录信息过期,请重新登录"
        } else if (statusCode ==  NOT_PERMISSION) {

            return "权限不足"
        }
        val response = e.response() ?: return "数据请求失败"
        val responseBody = response.errorBody() ?: return "数据请求失败"
        var respStr: String? = null
        try {
            respStr = responseBody.string()
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        if (TextUtils.isEmpty(respStr)) {
            return "数据请求失败"
        }
        try {
            val jsonObject = JSONObject(respStr)
            return jsonObject.optString("message", "数据请求失败")
        } catch (ex: JSONException) {
            ex.printStackTrace()
        }
        return "数据请求失败"
    }


    fun getDisposable(): Disposable? {
        return mDisposable
    }

}