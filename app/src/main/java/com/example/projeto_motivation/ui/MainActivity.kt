package com.example.projeto_motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.projeto_motivation.R
import com.example.projeto_motivation.infra.SecurityPreferences
import com.example.projeto_motivation.databinding.ActivityMainBinding
import com.example.projeto_motivation.infra.MotivationConstants


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryID = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        handleUserName()
        handleFilter(R.id.image_all_inclusive)

        binding.buttonNewPhrase.setOnClickListener(this)
        binding.buttonLogout.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageAllInclusive.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_new_phrase) {

        } else if (view.id == R.id.button_logout) {
            logout()
        } else if (view.id in listOf(
                R.id.image_all_inclusive,
                R.id.image_happy,
                R.id.image_sunny
            )
        ) {
            handleFilter(view.id)
        }
    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getStr(MotivationConstants.KEY.USER_NAME)
        binding.textTop.text = "Olá, $name!"
    }

    private fun logout() {
        SecurityPreferences(this).clearStr(MotivationConstants.KEY.USER_NAME)
        startActivity(Intent(this, UserActivity::class.java))
        finish()
    }

    private fun handleFilter(id: Int) {

        binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_all_inclusive -> {
                binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this,R.color.white))
                MotivationConstants.FILTER.ALL
            }
            R.id.image_happy -> {
                binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                MotivationConstants.FILTER.HAPPY
            }
            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                MotivationConstants.FILTER.SUNNY
            }
        }
    }
}