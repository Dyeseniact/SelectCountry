package com.example.seleccionarpais

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    var country = arrayOf("EUA", "México", "Brasil", "Francia", "Alemania", "Italia")

    var text = arrayOf(
        "Select your country",
        "Selecciona tu pais",
        "Selecione seu pais",
        "Selectionnez votre pays",
        "uidadh hdihd iahdd",
        "Seleziona il tuo paese"
    )

    var text2 = arrayOf(
        "Welcome to EUA",
        "Bienvenido a México",
        "Bem vindo ao Brasil",
        "Bienvenue en France",
        "uidadh hdihd iahdd",
        "benvenuti in Italia"
    )

    var boton2 = arrayOf(
        "Next",
        "Siguiente",
        "Siguiente",
        "Continuez",
        "dnionviod",
        "Continuare"
    )

    private lateinit var spinner: Spinner
    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinner)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                mostrar(
                    "No seleccionaste un pais",
                    "Vuelve a desplegar la lista y asegúrate de elegir correctamente a alguna"
                )
                Toast.makeText(applicationContext, "No país", Toast.LENGTH_LONG).show()
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(applicationContext, text2[position], Toast.LENGTH_LONG).show()
                textView.text = text[position]
                button.text = boton2[position]

            }

        }

        val countryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, country)

        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)



        spinner.adapter = countryAdapter


    }

    private fun mostrar(title: String, message: String) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { dialogInterface, which -> }
            .create()
            .show()
    }
}