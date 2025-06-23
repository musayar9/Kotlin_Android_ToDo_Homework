package com.example.todoapp_homework.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.todoapp_homework.R.id.toSaveScreen

import com.example.todoapp_homework.databinding.MainScreenBinding
import com.example.todoapp_homework.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreen : Fragment() {
private lateinit var viewModel:MainViewModel
private lateinit var binding: MainScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = MainScreenBinding.inflate(inflater, container,false)






        binding.fabBtn.setOnClickListener {
            it.findNavController().navigate(toSaveScreen)
        }
        return binding.root
    }


}