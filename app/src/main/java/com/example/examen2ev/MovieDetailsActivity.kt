package com.example.examen2ev

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examen2ev.databinding.ActivityMovieDetailsBinding
import com.google.gson.Gson

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listeners()
    }

    private fun listeners() {
        binding.siguiente.setOnClickListener {
            if(binding.director.text.toString().isEmpty())
                binding.director.error = "Campo obligatorio"
            else
                if(binding.lanzamiento.text.toString().isEmpty())
                    binding.lanzamiento.error = "Campo obligatorio"
                else
                    if(binding.lanzamiento.text.toString().toInt() == 0)
                        binding.lanzamiento.error = "El valor no puede ser 0"
                    else{
                        val nombrePeli = intent.getStringExtra("titulo").toString()
                        val duracion = intent.getStringExtra("duracion").toString()
                        val director = binding.director.text.toString()
                        val lanzamiento = binding.lanzamiento.text.toString()

                        println(nombrePeli)
                        println(duracion)
                        println(director)
                        println(lanzamiento)

                        val intent = Intent(this, MovieDisplayActivity::class.java)

                        intent.putExtra("titulo", nombrePeli)
                        intent.putExtra("duracion", duracion)
                        intent.putExtra("director", director)
                        intent.putExtra("lanzamiento", lanzamiento)

                        startActivity(intent)
                    }
        }

        binding.atras.setOnClickListener {
            startActivity(Intent(this, MovieTitleActivity::class.java))
        }
    }
}