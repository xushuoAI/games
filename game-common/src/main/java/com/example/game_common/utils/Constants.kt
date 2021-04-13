package com.example.game_common.utils

/**
 * @ClassNameDescription
 *
 * @Author xushuo
 * @Date 2021-04-13
 * @Description
 */

enum class SpinnerItems(val key: String, val values: String){

    ZHIHU("zhihu","知乎热榜"),
    WEIBO("weibo","微博热搜"),
    TOUTIAO("toutiao","今日头条"),
    WY163("163","网易新闻"),
    CSDN("csdn","CSDN推荐"),
    JUEJIN("juejin","掘金热榜"),
    DOUYIN("douyin","抖音视频榜");

    companion object{
        fun getKeyByValues(values: String): String{
            for (i in SpinnerItems.values()){
                if (i.values.equals(values)){
                    return i.key
                }
            }
            return ZHIHU.key
        }
    }


}
