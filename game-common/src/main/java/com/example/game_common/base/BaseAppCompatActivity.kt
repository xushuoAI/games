package com.example.game_common.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * @ClassNameDescription
 *
 * @Author xushuo
 * @Date 2021-04-13
 * @Description
 */
open class BaseAppCompatActivity: AppCompatActivity() {



    fun showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT)
    }

    fun showLongToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG)
    }

}