package com.example.games

import android.app.Application
import com.example.game_common.network.RetrofitHttp
import com.example.game_common.utils.Utils

/**
 * @ClassNameDescription App
 * 应用启动全局类 application
 *
 * @Author xushuo
 * @Date 2021-04-02
 * @Description
 */
class GamesApp : Application() {


    override fun onCreate() {
        super.onCreate()
        // 初始化操作，初始化控件
        Utils.init(this)
        // 初始化Retrofit
        RetrofitHttp.retrofit
    }


}