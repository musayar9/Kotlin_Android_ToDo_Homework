package com.example.todoapp_homework.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.todoapp_homework.R
import com.example.todoapp_homework.databinding.UpdateScreenBinding

import dagger.hilt.android.AndroidEntryPoint
import com.example.todoapp_homework.R.id.toMainScreen
import com.example.todoapp_homework.ui.viewmodel.UpdateViewModel

@AndroidEntryPoint
class UpdateScreen : Fragment() {

    private lateinit var binding: UpdateScreenBinding
    private lateinit var viewModel : UpdateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

            binding = UpdateScreenBinding.inflate(inflater, container, false)

        val bundle :UpdateScreenArgs by navArgs()
        val toDoUpdate = bundle.toDo

        binding.editUpdateTextName.setText(toDoUpdate.name)


        binding.updateBtn.setOnClickListener{

            if(binding.editUpdateTextName.text.toString().isNotEmpty()){
                val name = binding.editUpdateTextName.text.toString()
                viewModel.update(toDoUpdate.id, name)

                it.findNavController().navigate(toMainScreen)
                binding.editUpdateTextName.setText("")
                Toast.makeText(requireContext(), "Todo Güncellendi", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(), "Text alanı boş bırakılamaz", Toast.LENGTH_SHORT).show()
            }

        }
            return binding.root
    }
 override fun onCreate(savedInstanceState: Bundle?){
     super.onCreate(savedInstanceState)
     val tempViewModel:UpdateViewModel by viewModels()
     viewModel= tempViewModel
 }

}