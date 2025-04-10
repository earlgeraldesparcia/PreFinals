package com.personal.prefinals

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.personal.prefinals.data.UserCredentials


class RegisterActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val username = findViewById<EditText>(R.id.REGet_username)
        val password = findViewById<EditText>(R.id.REGet_password)
        val btnRegister = findViewById<Button>(R.id.REGbtn_register)
        val btnLogin = findViewById<Button>(R.id.REGbtn_login)

        btnRegister.setOnClickListener {
            if(username.text.toString().isNullOrEmpty() ||
                password.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, "Input fields cannot be empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val userCredentials = UserCredentials(username.text.toString(), password.text.toString())

            saveCredentials(this, userCredentials)

            Toast.makeText(this, "Registration successfull!", Toast.LENGTH_SHORT).show()
            startActivity(
                Intent(this, LoginActivity::class.java)
            )
        }

        btnLogin.setOnClickListener {
            startActivity(
                Intent(this, LoginActivity::class.java)
            )
        }



    }
    fun saveCredentials(context: Context, userCredentials: UserCredentials) {
        val sharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        val editor = sharedPreferences.edit()

        editor.putString("username", userCredentials.username)
        editor.putString("password", userCredentials.password)
        editor.apply()
    }
}