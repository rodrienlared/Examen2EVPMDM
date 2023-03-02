package com.example.examen2ev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examen2ev.databinding.ActivityMovieDetailsBinding
import com.example.examen2ev.databinding.ActivityMovieDisplayBinding

class MovieDisplayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDisplayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFields()

        binding.borrar.setOnClickListener {
            startActivity(Intent(this, MovieTitleActivity::class.java))
        }
    }

    private fun setFields() {
        binding.nombrePeli.text = "Nombre película: " + intent.getStringExtra("titulo").toString()
        binding.director.text = "Director: " + intent.getStringExtra("director").toString()
        binding.lanzamiento.text = "Año de lanzamiento: " + intent.getStringExtra("lanzamiento").toString()
        binding.minutos.text = "Duración (minutos): " + intent.getStringExtra("duracion").toString()
    }
}