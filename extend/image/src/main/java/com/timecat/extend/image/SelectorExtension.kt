package com.timecat.extend.image

import android.util.Log
import com.luck.picture.lib.basic.PictureSelectionCameraModel
import com.luck.picture.lib.basic.PictureSelectionModel
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.interfaces.OnResultCallbackListener
import java.util.ArrayList

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2020/6/10
 * @description 图片选择器 简化操作
 * @usage null
 */
/**
 * 可以通过PictureSelectorExternalUtils.getExifInterface();方法获取一些额外的资源信息
 * 如旋转角度、经纬度等信息
 */
fun LocalMedia.savablePath(): String? {
    Log.d("LocalMedia", "----------------")
    Log.d("LocalMedia", "是否压缩:$isCompressed")
    Log.d("LocalMedia", "压缩:$compressPath")
    Log.d("LocalMedia", "原图:$path")
    Log.d("LocalMedia", "是否裁剪:$isCut")
    Log.d("LocalMedia", "裁剪:$cutPath")
    Log.d("LocalMedia", "是否开启原图:$isOriginal")
    Log.d("LocalMedia", "原图路径:$originalPath")
    Log.d("LocalMedia", "----------------")
    return when {
        availablePath != null -> availablePath
        path != null -> path
        else -> null
    }
}

fun PictureSelectionModel.selectForResult(onSuccess: (MutableList<LocalMedia>) -> Unit) {
    forResult(object : OnResultCallbackListener<LocalMedia> {
        override fun onCancel() {
        }

        override fun onResult(result: ArrayList<LocalMedia>?) {
            result?.let {
                onSuccess(it)
            }
        }
    })
}
fun PictureSelectionCameraModel.selectForResult(onSuccess: (MutableList<LocalMedia>) -> Unit) {
    forResult(object : OnResultCallbackListener<LocalMedia> {
        override fun onCancel() {
        }

        override fun onResult(result: ArrayList<LocalMedia>?) {
            result?.let {
                onSuccess(it)
            }
        }
    })
}