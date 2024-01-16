package com.example.customcardalert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.customcardalert.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCardSuccess.setOnClickListener {
            DialogHelper.cardAlertSuccess(this) {
                Toast.makeText(this, "Dismiss card Success!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonCardFailed.setOnClickListener {
            DialogHelper.cardAlertFailed(this) {
                Toast.makeText(this, "Dismiss card Failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}