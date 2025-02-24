package com.example.assessment1

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.assessment1.ui.theme.Assessment1Theme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Call the JNI function
        val isTampered = IntegrityChecker.detectPlayIntegrityFix()
        Log.e("isTampered", isTampered.toString())
        if (isTampered) {
            showSecurityAlert(this, "Unauthorized modifications detected!")
        } else {
            showSecurityAlert(this, "Your phone is safe")
        }
        setContent {
            Assessment1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {

                }
            }
        }
    }
}

private fun showSecurityAlert(context: Context, message: String) {
    AlertDialog.Builder(context)
        .setTitle("Security Alert")
        .setMessage(message)
        .setCancelable(false)
        .setPositiveButton("Exit") { it, _ -> it.dismiss() }
        .show()
}