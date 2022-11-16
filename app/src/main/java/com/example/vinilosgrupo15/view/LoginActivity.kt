package com.example.vinilosgrupo15.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.vinilosgrupo15.R


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var btnLogin: Button = this.findViewById(R.id.login)
        btnLogin.setOnClickListener { vinylsIngress() }

        val spinner: Spinner = this.findViewById(R.id.rolList)
        ArrayAdapter.createFromResource(
            this,
            R.array.roles,
            android.R.layout.simple_spinner_item
        ).also {
                adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

    }

    private fun vinylsIngress() {
        var spRol:Spinner = findViewById(R.id.rolList)
        var formValido:Boolean = true
        var usuario:EditText = findViewById(R.id.editTextTextPersonName)
        var clave:EditText = findViewById(R.id.editTextTextPassword)

        var seleccionado:String = spRol.selectedItem.toString()

        if (usuario.text.toString().isBlank()) {
            formValido = false
            usuario.error = getString(R.string.campoobligatorio)
        }

        if (clave.text.toString().isBlank()) {
            formValido = false
            clave.error = getString(R.string.campoobligatorio)
        }

        if ( seleccionado == "Select rol" ) {
            formValido = false
            Toast.makeText(this, "Rol " + getString(R.string.campoobligatorio) , Toast.LENGTH_SHORT).show()
        }

        if (formValido) {
            val intent = Intent(this, MainActivity::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}