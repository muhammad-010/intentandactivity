package com.example.intentandactivity

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.intentandactivity.MainActivity
import com.example.intentandactivity.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    private val TAG = "ThirdActivityLifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(MainActivity.EXTRA_NAME)
        val email = intent.getStringExtra(MainActivity.EXTRA_EMAIL)
        val phone = intent.getStringExtra(MainActivity.EXTRA_PHONE)
        val gender = intent.getStringExtra(MainActivity.EXTRA_GENDER)

        binding.txtName.text = name
        binding.txtName2.text = name
        binding.txtEmail.text = email
        binding.txtEmail2.text = email
        binding.txtPhone.text = phone
        binding.txtJeniskelamin.text = gender
    }
}