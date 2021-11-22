package com.example.entrega_listeners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.*
import android.widget.Toast
import com.example.entrega_listeners.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    var word =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.b1.setOnClickListener {
            binding.tv1.text = (0..100).random().toString()
            binding.tv1.visibility = VISIBLE
        }

        binding.b2.setOnClickListener {
            binding.tv1.text = ('a'..'z').random().toString()
            binding.tv1.visibility = VISIBLE
        }

        binding.b3.setOnClickListener {
            word=""
            for (index in 0..4)
                word += ('a'..'z').random().toString()
            binding.tv1.text = word
            binding.tv1.visibility = VISIBLE

            if (binding.tv1.text.length == 5)
                binding.b4.visibility = VISIBLE
            else
                binding.b4.visibility = INVISIBLE

        }

        binding.b4.setOnClickListener() {
            var newChar = ('a'..'z').random().toString()
            var index = (0..4).random()
            var oldChar = word[index]

            Toast.makeText(this, "Cambio la letra $oldChar por la letra $newChar", Toast.LENGTH_LONG).show()
            word = word.indexOf(newChar,index, ignoreCase = false).toString()
            binding.tv1.text = word
        }

    }
}