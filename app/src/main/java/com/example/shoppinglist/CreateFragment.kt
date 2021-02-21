package com.example.shoppinglist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_create.*

class CreateFragment(var itemInterface: ItemInterface) : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_save.setOnClickListener(this)
    }

    companion object {
       @JvmStatic
        fun newInstance(itemInterface: ItemInterface) = CreateFragment(itemInterface)
    }

    override fun onClick(v: View?) {
        val date = input_date.text.toString()
        val name = input_name_item.text.toString()
        val price = input_price.text.toString()
        val quantity = input_quantity.text.toString()
        when(v) {
            button_save -> {
                if (date == "" || name == "" || price == "" || quantity == "") {
                    Toast.makeText(activity, "cannot add data, please fill all form ", Toast.LENGTH_SHORT).show()

                } else {
                    itemInterface.addItem(date, name, price, quantity)
                    Toast.makeText(activity, "Success add new item ", Toast.LENGTH_SHORT).show()


                }
            }
        }
    }
}