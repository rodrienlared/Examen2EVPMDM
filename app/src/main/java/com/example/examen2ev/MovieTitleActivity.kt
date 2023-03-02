package com.example.examen2ev

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examen2ev.databinding.ActivityMovieTitleBinding
import com.google.gson.Gson

class MovieTitleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieTitleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieTitleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listeners()
    }

    private fun listeners() {
        binding.siguiente.setOnClickListener {
            if(binding.tituloMovie.text.toString().isEmpty())
                binding.tituloMovie.error = "Campo obligatorio"
            else
                if(binding.duracion.text.toString().isEmpty())
                    binding.duracion.error = "Campo obligatorio"
                else
                    if(binding.duracion.text.toString().toInt() == 0)
                        binding.duracion.error = "El campo no puede ser 0"
                    else{
                        val intent = Intent(this, MovieDetailsActivity::class.java)
                        intent.putExtra("titulo", binding.tituloMovie.text.toString())
                        intent.putExtra("duracion", binding.duracion.text.toString())
                        startActivity(intent)
                    }
        }
    }
}