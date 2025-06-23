package com.example.todoapp_homework.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp_homework.data.entity.ToDoEntity
import com.example.todoapp_homework.data.repo.ToDoRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(var toDoRepo: ToDoRepo):ViewModel() {
    val toDoList = MutableLiveData<List<ToDoEntity>>()

    // loadTodo sınıfından bir nesne oluşturduğumuzda init alanını çalıştır.
    init {
        loadTodoData()
    }

        fun loadTodoData(){
            CoroutineScope(Dispatchers.Main).launch {
                // burada reposityorydeki loadTodo fun çalışacak
                toDoList.value = toDoRepo.laodTodoData()
            }
        }

            fun search(searchText:String){
            CoroutineScope(Dispatchers.Main).launch {
                toDoList.value= toDoRepo.searchToDo(searchText)
            }
        }

        fun delete(id:Int){
            CoroutineScope(Dispatchers.Main).launch {
                toDoRepo.deleteToDo(id)
            }
        }


}