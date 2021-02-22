package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_create.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val buttonAdd = findViewById<Button>(R.id.button_add)
        buttonAdd.setOnClickListener{
            findNavController(R.id.nav_host_fragment).navigate(R.id.action_global_createFragment2)
        }

        val buttonList = findViewById<Button>(R.id.button_list)
        buttonList.setOnClickListener {
            findNavController(R.id.nav_host_fragment_container).navigate(R.id.action_global_listFragment)
        }
    }

}