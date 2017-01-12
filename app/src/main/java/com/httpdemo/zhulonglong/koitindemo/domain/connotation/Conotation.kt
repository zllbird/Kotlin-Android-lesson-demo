package com.httpdemo.zhulonglong.koitindemo.domain.connotation

import java.lang.reflect.Type

/**
 * Created by zhulonglong on 2017/1/12.
 */
data class Conotation(val id :Long , val media_type:Int,val text:String,
                      val large_image:ConotationImage,
                      val gifvideo:ConotationGIF){
    var typeClass: Class<out Any> = ConotationText::class.java
            get() {
                when(media_type){
                    1 -> return ConotationImage::class.java
                    2 -> return ConotationGIF::class.java
                    else -> return ConotationText::class.java
                }
            }
}

data class ConotationText(val text: String)
data class ConotationImage(val uri:String)
data class ConotationGIF(val origin_video:ConotationGIFR)
data class ConotationGIFR(val uri:String)