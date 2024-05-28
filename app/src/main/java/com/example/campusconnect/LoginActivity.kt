package com.example.campusconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var signIn : Button
    private lateinit var email : EditText
    private lateinit var password : EditText
    private val auth =FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signIn=findViewById(R.id.buttonSignIn)
        email=findViewById(R.id.editTextLoginEmail)
        password=findViewById(R.id.editTextLoginPassword)

        signIn.setOnClickListener {
            val userEmail = email.text.toString()
            val userPassword =password.text.toString()

            signInUser(userEmail,userPassword)

        }
    }

    private fun signInUser(userEmail : String, userPassword : String)
    {
        auth.signInWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener {
                task->

            if(task.isSuccessful)
            {
                Toast.makeText(applicationContext,"Welcome to IET", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@LoginActivity,MainActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(applicationContext,task.exception?.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }

    }
    override fun onStart() {
        super.onStart()

        val user =auth.currentUser

        if(user!=null)
        {
            Toast.makeText(applicationContext,"Welcome to IET College App",Toast.LENGTH_SHORT).show()
            val intent =Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}