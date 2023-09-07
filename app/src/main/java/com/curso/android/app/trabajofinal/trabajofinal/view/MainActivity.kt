package com.curso.android.app.trabajofinal.trabajofinal.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.curso.android.app.trabajofinal.trabajofinal.ViewModel.CompararViewModel
import com.curso.android.app.trabajofinal.trabajofinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val compararViewModel : CompararViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


       binding.button.setOnClickListener{
            compararViewModel.setPalabra1(binding.editTextText.text.toString())
            compararViewModel.setPalabra2(binding.editTextText2.text.toString())
            compararViewModel.compararCadenas()
        }

        compararViewModel.compararModel.observe(this, Observer {

            binding.textView3.text= if (it.iguales) "Son iguales" else "Son diferentes"})


    }
}