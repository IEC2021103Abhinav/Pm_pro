package com.example.hbdpm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.hbdpm.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding

    private var tvHead:TextView?=null
    private var tvName:TextView?=null
    private var etName:EditText?=null
    private var tvPass:TextView?=null
    private var etPass:EditText?=null
    private var btnSubmit:Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        tvHead=binding.textView3
        tvName=binding.textView4
        etName=binding.logemail
        tvPass=binding.tv5
        etPass=binding.logPwd
        btnSubmit=binding.loinBtn
        btnSubmit!!.setOnClickListener{
            if(checkUser())
            {
                val intent= Intent(this@LoginActivity,MainActivity::class.java)
                startActivity(intent)
            }

        }

    }
    private  fun checkUser():Boolean
    {
        val name=etName!!.text.toString()
        val password=etPass!!.text.toString()
        if(name=="Rimjhim Mehta" && password=="Yes")
        {
            return true;
        }
        else
        {
            if(name!="Rimjhim Mehta" )
            {
                etName?.error="Sahi see likho!!"
                return false;
            }
            if(password!="Yes")
            {
                etPass?.error="Yes likhoo!!"
                return false;
            }
            return false;
        }

    }

}