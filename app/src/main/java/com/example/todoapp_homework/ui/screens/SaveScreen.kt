package com.example.todoapp_homework.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.todoapp_homework.R
import com.example.todoapp_homework.databinding.SaveScreenBinding
import com.example.todoapp_homework.ui.viewmodel.SaveViewModel
import dagger.hilt.android.AndroidEntryPoint
import  com.example.todoapp_homework.R.id.toMainScreen
@AndroidEntryPoint
class SaveScreen : Fragment() {

private lateinit var binding:SaveScreenBinding
private lateinit var viewModel: SaveViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =SaveScreenBinding.inflate(inflater, container, false)
        binding.saveBtn.setOnClickListener{

            if(binding.editTextName.text.toString().isNotEmpty()){
                val toDoText = binding.editTextName.text.toString()
                viewModel.saveToDo(toDoText)

                it.findNavController().navigate(toMainScreen)
                binding.editTextName.setText("")

            }else{
                Toast.makeText(requireContext(), "Text alanı boş bırakılamaz", Toast.LENGTH_SHORT).show()
            }


        }
    return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        val tempViewModel:SaveViewModel by viewModels()
        viewModel=tempViewModel

    }

}