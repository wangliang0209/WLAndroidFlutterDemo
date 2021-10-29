package com.wl.android.flutterdemo

import android.app.Application
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

/**
 * @author wangliang at 2021/10/26
 */
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initFlutter()
    }

    private fun initFlutter() {
        FlutterHelper.init(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        FlutterHelper.destroy()
    }
}