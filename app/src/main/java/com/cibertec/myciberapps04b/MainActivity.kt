package com.cibertec.myciberapps04b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->

            if (!task.isSuccessful) {
                Log.e("FirebaseError", task.exception.toString())
                println("FirebaseError: " + task.exception.toString())
                return@addOnCompleteListener
            }

            val token = task.result
            Log.e("FirebaseToken", token)
            println("FirebaseToken: $token")

        }
    }
}