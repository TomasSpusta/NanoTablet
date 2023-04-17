package com.example.spinnertutorial

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("SetJavaScriptEnabled")
fun setupWebView (myWeb:WebView) {
    CoroutineScope(Dispatchers.Main).launch {
        //val myWeb = findViewById<WebView>(R.id.web_view)
        //myWeb.loadUrl("https://google.com")
        myWeb.settings.javaScriptEnabled = true
        myWeb.settings.domStorageEnabled = true
        myWeb.webViewClient = WebViewClient()
        myWeb.loadUrl("https://today.ceitec.cz/nano/")
    }
}