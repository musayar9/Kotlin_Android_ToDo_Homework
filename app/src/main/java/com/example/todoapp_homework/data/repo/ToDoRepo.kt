package com.example.todoapp_homework.data.repo

import com.example.todoapp_homework.data.datasource.ToDoDataSource
import com.example.todoapp_homework.data.entity.ToDoEntity

class ToDoRepo(var toDoDataSource: ToDoDataSource) {

    suspend fun laodTodoData():List<ToDoEntity> = toDoDataSource.loadTodoData()

    suspend fun searchToDo(searchText:String):List<ToDoEntity> = toDoDataSource.search(searchText)

    suspend fun saveToDo(name:String)= toDoDataSource.saveTodo(name)

    suspend fun updateToDo(id:Int, name:String)= toDoDataSource.udpateTodo(id, name)

    suspend fun deleteToDo(id:Int)=toDoDataSource.delete(id)




}