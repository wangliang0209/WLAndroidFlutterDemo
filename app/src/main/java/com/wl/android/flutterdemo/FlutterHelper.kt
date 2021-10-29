package com.wl.android.flutterdemo

import android.content.Context
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

/**
 * @author wangliang at 2021/10/26
 */
object FlutterHelper {

    private const val ENGINE_ID_PREFIX = "oda_class_engine_"
    const val METHOD_CHANNEL = "pigeon_oda_class"
    const val ROUTE_PAGE_1 = "page_1"
    const val ROUTE_PAGE_2 = "page_2"

    private val ROUTE_LIST = arrayListOf(
        ROUTE_PAGE_1,
        ROUTE_PAGE_2
    )

    fun flutterEngineId(route: String) = ENGINE_ID_PREFIX + route

    fun init(context: Context) {
        ROUTE_LIST.forEach { route ->
            initEngineByRoute(context, route)
        }
    }

    private fun initEngineByRoute(context: Context, route: String) {
        val engine = FlutterEngine(context)
        engine.navigationChannel.setInitialRoute(route)
        engine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )
        FlutterEngineCache.getInstance().put(flutterEngineId(route), engine)
    }

    fun getEngine(route: String) {
        FlutterEngineCache.getInstance().get(flutterEngineId(route))
    }

    fun destroy() {
        FlutterEngineCache.getInstance().clear()
    }
}