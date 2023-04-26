package com.example.rkmovies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.rkmovies.databinding.ActivitySinupBinding
import com.google.firebase.auth.FirebaseAuth


class Sinup : AppCompatActivity() {

    private lateinit var binding: ActivitySinupBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySinupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.sinupbtn.setOnClickListener {
            val name = binding.edtname.text.toString()
            val email = binding.edteml.text.toString()
            val pass = binding.edtpass.text.toString()
            val cpass = binding.edtcpass.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty() && cpass.isNotEmpty()){
                if (pass == cpass){
                    auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful){
                            val intent = Intent(this,MainActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, "Signup failed", Toast.LENGTH_SHORT).show()
                        }
                    }

                }else{
                    Toast.makeText(this, "password not match", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "please fill all crediantial", Toast.LENGTH_SHORT).show()
            }
        }

        binding.login.setOnClickListener {
           onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding != null
    }

}