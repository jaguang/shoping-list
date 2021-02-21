package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_create.*

class MainActivity : AppCompatActivity(),ItemInterface {
    private lateinit var createFragment: CreateFragment
    private lateinit var listFragment: ListFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createFragment = CreateFragment.newInstance(this)
        switchFragment(createFragment)
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_in,R.anim.slide_out)
                .replace(R.id.fragment_container,fragment)
                .commit()
    }

    fun onCickList(view:View) {
        listFragment  = ListFragment()
        switchFragment(listFragment)
    }

    fun onClickadd(view: View) {
        switchFragment(createFragment)
    }


    override fun addItem(date: String, name: String, price: String, quantity: String) {
        itemList.add(
                Item(
                        date,
                        name,
                        price,
                        quantity
                )
        )
    }
}