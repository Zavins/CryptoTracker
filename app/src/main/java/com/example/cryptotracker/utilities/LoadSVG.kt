package com.example.cryptotracker.utilities

import android.widget.ImageView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.CachePolicy
import coil.request.ImageRequest

class LoadSVG {
    companion object {
        fun loadSvg(iv: ImageView, url: String) {

            val imageLoader = ImageLoader.Builder(iv.context)
                .components{ add(SvgDecoder.Factory())}
                .memoryCachePolicy(policy = CachePolicy.ENABLED)
                .build()

            val request = ImageRequest.Builder(iv.context)
                .data(url)
                .target(iv)
                .build()

            imageLoader.enqueue(request)
        }
    }
}