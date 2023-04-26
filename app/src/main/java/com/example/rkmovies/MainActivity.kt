package com.example.rkmovies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.rkmovies.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.logbtn.setOnClickListener {
            val email = binding.edteml.text.toString()
            val pass = binding.edtpass.text.toString()
            if (email.isNotEmpty() && pass.isNotEmpty()){
                auth.signInWithEmailAndPassword(email , pass).addOnCompleteListener {
                    if (it.isSuccessful){
                        val intent = Intent(this,Home::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this, "fill all credentials", Toast.LENGTH_SHORT).show()
            }
        }

        binding.sinup.setOnClickListener{
            val intent = Intent(this,Sinup::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding != null
    }
}