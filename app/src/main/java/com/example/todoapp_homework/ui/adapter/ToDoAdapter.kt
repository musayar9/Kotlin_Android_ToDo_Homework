package com.example.todoapp_homework.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp_homework.data.entity.ToDoEntity
import com.example.todoapp_homework.databinding.CardDesignBinding
import com.example.todoapp_homework.ui.screens.MainScreenDirections
import com.example.todoapp_homework.ui.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class ToDoAdapter(var mContext:Context, var toDoList:List<ToDoEntity>, var viewModel:MainViewModel)
    :RecyclerView.Adapter<ToDoAdapter.CardHolder>() {


    inner class CardHolder(var binding: CardDesignBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
    val binding = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardHolder(binding)
    }

    override fun getItemCount(): Int = toDoList.size


    override fun onBindViewHolder(holder: CardHolder, position: Int) {
       val toDoApp = toDoList.get(position)
        val toDoDesign = holder.binding
        toDoDesign.textView.text = toDoApp.name.toString()
        toDoDesign.toDoContent.setOnClickListener{
            val toUpdateScreen = MainScreenDirections.toUpdateScreen(toDo = toDoApp)
            it.findNavController().navigate(toUpdateScreen)
        }

        toDoDesign.deleteIcon.setOnClickListener {
            Snackbar.make(it, "Do you want to delete ${toDoApp.name} ? ", Snackbar.LENGTH_SHORT)
                .setAction("Yes") {
                    viewModel.delete(toDoApp.id)
                }.show()

        }
    }


}