package com.example.dialogfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dialogfragment.controller.Controller
import com.example.dialogfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var controller: Controller


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init() //inicializo la clase
    }


    private fun init() {
        controller = Controller(this)
        controller.setActionEvent()
    }
}