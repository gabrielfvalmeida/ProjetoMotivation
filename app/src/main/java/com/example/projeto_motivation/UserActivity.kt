package com.example.projeto_motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.projeto_motivation.databinding.ActivityMainBinding
import com.example.projeto_motivation.databinding.ActivityUserBinding


class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.buttonSave.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            handleSave()
        }
    }

    private fun handleSave() {
        if (binding.editName.text.toString() != "") {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        } else Toast.makeText(this, R.string.mandatory_name, Toast.LENGTH_SHORT).show()
    }
}