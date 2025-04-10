package com.personal.prefinals

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.personal.prefinals.data.UserCredentials

class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val username = findViewById<EditText>(R.id.LOGet_username)
        val password = findViewById<EditText>(R.id.LOGet_password)
        val btnLogin = findViewById<Button>(R.id.LOGbtn_login)
        val btnRegister = findViewById<Button>(R.id.LOGbtn_register)

        btnLogin.setOnClickListener {
            if(username.text.toString().isNullOrEmpty() ||
                password.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, "Input fields cannot be empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val storeCredentials = getCredential(this)
            if(storeCredentials != null) {
                if(username.text.toString() == storeCredentials.username &&
                    password.text.toString() == storeCredentials.password) {
                    startActivity(
                        Intent(this, HomeScreenActivity::class.java)
                    )
                }else{
                    Toast.makeText(this, "Incorrect username or password!", Toast.LENGTH_SHORT).show()
                }
            }

        }

        btnRegister.setOnClickListener {
            startActivity(
                Intent(this, RegisterActivity::class.java)
            )
        }
    }

    fun getCredential(context: Context): UserCredentials? {
        val sharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        val username = sharedPreferences.getString("username", null)
        val password = sharedPreferences.getString("password", null)

        if(username != null && password != null) {
            return UserCredentials(username, password)
        }
        return null
    }
}