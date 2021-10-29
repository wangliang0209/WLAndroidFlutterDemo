package com.wl.android.flutterdemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.FlutterActivityLaunchConfigs
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant

class OdaFlutterActivity : FlutterActivity() {

    companion object {

        private const val TAG = "OdaFlutterActivity"
        private const val ARG_ROUTE = "$TAG.route"

        fun createIntent(context: Context, route: String) = CachedEngineIntentBuilder(
            OdaFlutterActivity::class.java,
            FlutterHelper.flutterEngineId(route)
        ).build(context).apply {
            putExtra(ARG_ROUTE, route)
        }
    }

    private var route: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        route = intent.getStringExtra(ARG_ROUTE)
        Log.d(TAG, "route $route")
    }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        GeneratedPluginRegistrant.registerWith(flutterEngine)
        setupMethodChannel()
    }

    private fun setupMethodChannel() {
        MethodChannel(
            flutterEngine?.dartExecutor,
            FlutterHelper.METHOD_CHANNEL
        ).setMethodCallHandler { call, result ->
            if (call.method.equals("goBack")) {
                Log.d(TAG, "arguments: ${call.arguments as String}")
                finish()
            } else {
                Log.d(TAG, "the method ${call.method} implement")
            }
        }
    }

    override fun getInitialRoute(): String? {
        Log.d(TAG, "getInitialRoute $route")
        return route
    }
}