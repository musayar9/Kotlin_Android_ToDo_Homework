package com.example.todoapp_homework.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp_homework.R.id.toSaveScreen

import com.example.todoapp_homework.databinding.MainScreenBinding
import com.example.todoapp_homework.ui.adapter.ToDoAdapter
import com.example.todoapp_homework.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreen : Fragment() {

    private lateinit var binding: MainScreenBinding
    private lateinit var viewModel:MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = MainScreenBinding.inflate(inflater, container,false)

    viewModel.toDoList.observe(viewLifecycleOwner){
        val toDoAdapter = ToDoAdapter(requireContext(), it, viewModel)
        binding.recyclerViewToDo.adapter = toDoAdapter
    }

        binding.recyclerViewToDo.layoutManager = LinearLayoutManager(requireContext())

        binding.fabBtn.setOnClickListener {
            it.findNavController().navigate(toSaveScreen)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        val tempViewModel:MainViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadTodoData()
    }


}