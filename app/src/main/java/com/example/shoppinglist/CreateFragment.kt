package com.example.shoppinglist

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_create.*
import java.util.*

class CreateFragment : Fragment(),View.OnClickListener {

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

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        input_date.setInputType(InputType.TYPE_NULL)
        input_date.setOnClickListener(View.OnClickListener {
            val datePickerDialog = activity?.let { it1 ->
                DatePickerDialog(
                        it1, DatePickerDialog.OnDateSetListener
                { view, year, monthOfYear, dayOfMonth ->
                    input_date.setText(
                            "$year/$monthOfYear/$dayOfMonth",
                            TextView.BufferType.EDITABLE
                    );
                }, year, month, day
                )
            }
            datePickerDialog?.show()
        })
    }

    companion object {
       @JvmStatic
        fun newInstance() = CreateFragment()
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
                    addItem(date, name, price, quantity)
                    Toast.makeText(activity, "Success add new item ", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}