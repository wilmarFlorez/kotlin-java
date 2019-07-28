package com.wilmarflorez.javaykotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var edtxPassword: EditText
    lateinit var btnLogin: Button
    lateinit var edtxUser: EditText



    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtxUser = findViewById(R.id.edtxLoginUsername)
        edtxPassword = findViewById(R.id.edtxLoginPassword)
        btnLogin = findViewById(R.id.btnLogin)

        val sharedPreferences = getSharedPreferences("Kotlinpre", Context.MODE_PRIVATE)
        val isLogged = sharedPreferences.getBoolean("loggeado", false)

        if(isLogged) {
            startActivity(Intent(this@MainActivity, LlistadoActivity::class.java))
            finish()
        }

        btnLogin.setOnClickListener {
            val isValid = edtxPassword.passwordValida()
            Log.e(TAG, "onClick: $isValid")
            if (isValid) {
                //Init view
                //startActivity(Intent(this@MainActivity, LlistadoActivity::class.java))

                val intent = Intent(this@MainActivity, LlistadoActivity::class.java)
                intent.putExtra("usuario", edtxUser.text.toString())
                startActivity(intent)

                sharedPreferences.edit(){
                    putBoolean("loggeado", true)
                }
            } else {

            }
        }


    }

}
