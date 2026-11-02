package com.example.compteurapp


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvCounter = findViewById<TextView>(R.id.tvCounter)
        val btnIncrement = findViewById<Button>(R.id.btnIncrement)
        val btnDecrement = findViewById<Button>(R.id.btnDecrement)

        // Récupération du ViewModel
        viewModel = ViewModelProvider(this)
            .get(CounterViewModel::class.java)

        // Observer les changements du compteur
        viewModel.counter.observe(this) { value ->
            tvCounter.text = "Compteur : $value"
        }

        // Bouton Incrémenter
        btnIncrement.setOnClickListener {
            viewModel.increment()
        }

        // Bouton Décrémenter
        btnDecrement.setOnClickListener {
            viewModel.decrement()
        }
    }
}
