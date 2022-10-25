package com.timecat.extend.image

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.luck.picture.lib.engine.CropFileEngine
import com.yalantis.ucrop.UCrop
import com.yalantis.ucrop.UCropImageEngine

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2022/10/25
 * @description null
 * @usage null
 */
class UCropImgEngine : UCropImageEngine {
    override fun loadImage(context: Context, url: String, imageView: ImageView) {
        Glide.with(context).load(url).into(imageView);
    }

    override fun loadImage(context: Context, url: Uri, maxWidth: Int, maxHeight: Int, call: UCropImageEngine.OnCallbackListener<Bitmap>) {
        Glide.with(context)
            .asBitmap()
            .load(url).override(maxWidth, maxHeight)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    call.onCall(resource)
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                }

            })
    }
}

class CropEngine(val context: Context, val init: (UCrop) -> Unit) : CropFileEngine {
    override fun onStartCrop(fragment: Fragment, srcUri: Uri, destinationUri: Uri, dataSource: ArrayList<String>?, requestCode: Int) {
        val uCrop = UCrop.of(srcUri, destinationUri, dataSource)
        uCrop.setImageEngine(UCropImgEngine())
        init(uCrop)
        uCrop.start(context, fragment, requestCode)
    }
}