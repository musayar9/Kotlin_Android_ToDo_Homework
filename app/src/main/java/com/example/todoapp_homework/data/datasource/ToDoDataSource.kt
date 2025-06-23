package com.example.todoapp_homework.data.datasource

import com.example.todoapp_homework.data.entity.ToDoEntity
import com.example.todoapp_homework.room.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource(var toDoDao: ToDoDao) {


    // buradaki amacım toDo'ları arayüze iletmek
    suspend fun loadTodoData():List<ToDoEntity> = withContext(Dispatchers.IO){
        return@withContext toDoDao.loadTodoData()
    }


    suspend fun search(searchText:String):List<ToDoEntity> = withContext(Dispatchers.IO){
        return@withContext toDoDao.searchTodo(searchText)
    }

    // burada toDoDao'ya dataSource üzerinden toDo veritabanıma veri gönderiyorum
    suspend fun saveTodo(name:String){
        val addNewTodo = ToDoEntity(0, name)
        toDoDao.saveTodo(addNewTodo)
    }

    // updateTodo ile'de vertabanınmdaki ilgili todo'yu güncelleyeceğim
    suspend fun udpateTodo(id:Int, name: String) = toDoDao.updateTodo(id,name)


    // deleteTodo ile ilgili toDo silmek için
    suspend fun delete(id:Int){
        val deleteTodo = ToDoEntity(id, "" )
        toDoDao.delete(deleteTodo)
    }

}