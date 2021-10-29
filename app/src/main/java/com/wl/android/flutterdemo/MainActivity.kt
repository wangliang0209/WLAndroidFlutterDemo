package com.wl.android.flutterdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import io.flutter.embedding.android.FlutterActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.btnGotoActivity1).setOnClickListener {
            startActivity(OdaFlutterActivity.createIntent(this, FlutterHelper.ROUTE_PAGE_1))
        }

        findViewById<Button>(R.id.btnGotoActivity2).setOnClickListener {
            startActivity(OdaFlutterActivity.createIntent(this, FlutterHelper.ROUTE_PAGE_2))
        }
    }
}