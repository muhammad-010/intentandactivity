package com.example.intentandactivity;

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intentandactivity.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
        const val EXTRA_GENDER = "extra_gender"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val phone = intent.getStringExtra(EXTRA_PHONE)
        val gender = intent.getStringExtra(EXTRA_GENDER)

        binding.login.text = getString(R.string.login)

        binding.loginUsername.setText(name)
        binding.loginPassword.setText("")

        binding.btnToLogin.setOnClickListener {
            val username = binding.loginUsername.text.toString()
            val password = binding.loginPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
                val storedUsername = sharedPreferences.getString("USERNAME", null)
                val storedPassword = sharedPreferences.getString("PASSWORD", null)

                if (username == storedUsername && password == storedPassword) {
                    Toast.makeText(this@SecondActivity, "Login Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@SecondActivity, ThirdActivity::class.java).apply {
                        putExtra(EXTRA_EMAIL, email)
                        putExtra(EXTRA_PHONE, phone)
                        putExtra(EXTRA_NAME, name)
                        putExtra(EXTRA_GENDER, gender)
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(this@SecondActivity, "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@SecondActivity, "Please enter both username and password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}