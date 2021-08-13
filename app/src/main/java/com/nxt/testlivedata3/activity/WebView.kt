package com.nxt.testlivedata3.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.nxt.testlivedata3.R
import kotlinx.android.synthetic.main.activity_web_view.*

class WebView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val url = intent.getStringExtra("url")
        web_view.webViewClient = WebViewClient()
        web_view.loadUrl(url!!)
    }
}