package com.example.pengenalanukm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        auth = FirebaseAuth.getInstance()

        btnUkm.setOnClickListener {
            Intent(this@HomeActivity, UkmActivity::class.java).also {
                startActivity(it)
            }
        }
        btnProfil.setOnClickListener {
            Intent(this@HomeActivity, ProfileActivity::class.java).also {
                startActivity(it)
            }
        }
        btnLogout.setOnClickListener {
            auth.signOut()
            Intent(this@HomeActivity, LoginActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
}
