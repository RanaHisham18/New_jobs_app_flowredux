package com.rana.new_jobs_app_flowredux.app

import android.app.Application
import coil.Coil
import coil.ImageLoader
import coil.decode.SvgDecoder
import com.rana.new_jobs_app_flowredux.Di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
// I put it to follow the complete cycle of jobs app, we (almost) will not use it.
        val imageLoader = ImageLoader.Builder(this).componentRegistry {
            add(SvgDecoder(this@NewsApplication))
        }.build()

        Coil.setImageLoader(imageLoader)

        startKoin {
            androidContext(this@NewsApplication)
            modules(
                listOf(
                    networkModule,
                )
            )
        }

    }
}