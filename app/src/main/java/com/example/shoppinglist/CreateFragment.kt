package com.example.shoppinglist

import android.app.Activity
import android.app.DatePickerDialog
import android.drm.DrmStore
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.shoppinglist.databinding.FragmentCreateBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_create.*
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.android.synthetic.main.loading_dialog.*
import java.util.*

class CreateFragment : Fragment(),AdapterView.OnItemSelectedListener {
    lateinit var mainModel: MainModel
    lateinit var binding: FragmentCreateBinding
    lateinit var loadingDialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCreateBinding.inflate(layoutInflater)


        binding.apply {
            buttonSave.setOnClickListener {
                val date = inputDate.text.toString()
                val name = inputNameItem.text
                val price = inputPrice.text.toString()
                val quantity = inputQuantity.text.toString()
                   mainModel.inputValidation(date, name.toString(), price, quantity)

            }
            return binding.root
        }
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadingDialog = LoadingDialog.build(requireContext())
        mainModel = ViewModelProvider(requireActivity()).get(MainModel::class.java)
        subscribe()
        val adapter = ArrayAdapter(requireActivity(),android.R.layout.simple_spinner_item,mainModel.name)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        name_item.adapter = adapter
        name_item.onItemSelectedListener = this@CreateFragment

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

    private fun subscribe() {
        mainModel.isValid.observe(requireActivity(), {
            when (it.status) {
                ResourceStatus.LOADING -> loadingDialog.show()
                ResourceStatus.SUCCESS -> {
                    loadingDialog.hide()
                    Toast.makeText(
                            requireContext(),
                            it.message,
                            Toast.LENGTH_LONG
                    ).show()
                }
                ResourceStatus.FAIL -> {
                    loadingDialog.hide()
                    Toast.makeText(
                        requireContext(),
                        it.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = CreateFragment()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        input_name_item.text = mainModel.name[p2]
    }
}

