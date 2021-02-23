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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist.databinding.FragmentCreateBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_create.*
import java.util.*

class CreateFragment : Fragment() {
    lateinit var mainModel: MainModel
    lateinit var binding: FragmentCreateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainModel = ViewModelProvider(requireActivity()).get(MainModel::class.java)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateBinding.inflate(layoutInflater)
        binding.apply {
            buttonSave.setOnClickListener {
                val date = inputDate.text.toString()
                val name = inputNameItem.text.toString()
                val price = inputPrice.text.toString()
                val quantity = inputQuantity.text.toString()
                if (date == "" || name == "" || price == "" || quantity == "") {
                    Toast.makeText(activity, "cannot add data, please fill all form ", Toast.LENGTH_SHORT).show()
                } else {
                    mainModel.addItem(date, name, price, quantity)
                    Toast.makeText(activity, "Success add new item ", Toast.LENGTH_SHORT).show()
                }
            }
            return binding.root
        }
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
}

