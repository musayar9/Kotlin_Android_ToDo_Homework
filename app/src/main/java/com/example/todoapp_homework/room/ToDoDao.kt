package com.example.todoapp_homework.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todoapp_homework.data.entity.ToDoEntity


@Dao

interface ToDoDao {

    // veritabanına erişim sağlayabileceğimiz final kodlar burada olacak.

    // veri çekme işlemleri
    @Query("SELECT * FROM toDo")
    suspend fun loadTodoData():List<ToDoEntity>


    // todo'ya veri kaydetme
    @Insert
    suspend fun saveTodo(toDo:ToDoEntity)

    // todo versinis id değerine göre güncelleme
    @Query("UPDATE toDo SET name = :name WHERE id = :id")
    suspend fun updateTodo(id:Int, name:String)


    // todo'yo id değerine göre silme
    @Delete
    suspend fun delete(toDo: ToDoEntity)


    // ilgili todo'yu search etme
    @Query("SELECT * FROM todo WHERE name LIKE '%' || :searchTodo || '%'")
    suspend fun searchTodo(searchTodo:String):List<ToDoEntity>


}