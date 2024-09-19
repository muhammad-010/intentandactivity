package com.example.intentandactivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intentandactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivityLifecycle"

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
        const val EXTRA_GENDER = "extra_gender"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToSecondActivity.setOnClickListener {
            val username = binding.regisNama.text.toString()
            val password = binding.regisPassword.text.toString()
            val email = binding.regisEmail.text.toString()
            val phone = binding.regisNomor.text.toString()
            val gender = if (binding.radioMale.isChecked) "Laki-laki" else "Perempuan"

            if (username.isNotEmpty() && password.isNotEmpty()) {
                val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("USERNAME", username)
                editor.putString("PASSWORD", password)
                editor.apply()

                val intentToSecondActivity = Intent(this@MainActivity, SecondActivity::class.java).apply {
                    putExtra(EXTRA_NAME, username)
                    putExtra(EXTRA_EMAIL, email)
                    putExtra(EXTRA_PHONE, phone)
                    putExtra(EXTRA_GENDER, gender)
                }
                startActivity(intentToSecondActivity)
            } else {
                Toast.makeText(this, "Please enter all required fields and accept the terms", Toast.LENGTH_SHORT).show()
            }
        }
    }
}