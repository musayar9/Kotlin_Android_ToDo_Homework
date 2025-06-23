package com.example.todoapp_homework.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp_homework.data.entity.ToDoEntity


// veri tabanını temsil eder.
@Database(entities = [ToDoEntity::class], version = 1)
abstract class ToDoDatabase:RoomDatabase() {
    abstract fun getToDoDao():ToDoDao
}