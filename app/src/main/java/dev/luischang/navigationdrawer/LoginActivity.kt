package dev.luischang.navigationdrawer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val btLogin: Button = findViewById(R.id.btLogin)

        btLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            // Aquí puedes agregar la lógica para iniciar sesión
            // Por ejemplo, puedes verificar las credenciales en una base de datos
            // y mostrar un mensaje de error si las credenciales son incorrectas
            if(email == "admin" && password == "admin"){
                // Credenciales correctas, iniciar sesión
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                // Credenciales incorrectas, mostrar mensaje de error
                etEmail.error = "Credenciales incorrectas"
            }
        }
    }
}