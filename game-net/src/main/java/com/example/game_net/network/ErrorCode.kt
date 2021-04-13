package com.example.game_net.network

/**
 * 网络错误
 */
const val NETWORK_ERROR = 0

/**
 * 请求参数错误或者接口报错
 */
const val REQUEST_FAIL = 400

/**
 * 登录信息过期或者没有登录
 */
const val NOT_LOGIN = 401

/**
 * 权限不足
 */
const val NOT_PERMISSION = 403

/**
 * 服务器内部错误
 */
const val SYSTEM_ERROR = 500