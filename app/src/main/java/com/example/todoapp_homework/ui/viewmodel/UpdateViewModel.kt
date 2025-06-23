package com.example.todoapp_homework.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp_homework.data.repo.ToDoRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UpdateViewModel @Inject constructor(var toDoRepo: ToDoRepo):ViewModel() {

    fun update(id:Int, name:String){
        CoroutineScope(Dispatchers.Main).launch {
            toDoRepo.updateToDo(id, name)
            toDoRepo.laodTodoData()
        }
    }

}