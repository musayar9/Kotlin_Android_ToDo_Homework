package com.example.todoapp_homework.di

import com.example.todoapp_homework.data.datasource.ToDoDataSource
import com.example.todoapp_homework.data.repo.ToDoRepo
import com.example.todoapp_homework.room.ToDoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

import dagger.hilt.android.qualifiers.ApplicationContext
// bu sınıf benim projemde ne kadar ihtiyaç varsa onu karşılacak olan sınıf


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    // bu fonksiyon için daışarıdan dataSource nesnesi istedil
    fun provideToDoRepository(toDoDataSource: ToDoDataSource):ToDoRepo{
        return ToDoRepo(toDoDataSource)
    }



    @Provides
    @Singleton
    fun provideToDoDataSource(toDoDao: ToDoDao):ToDoDataSource{
        return ToDoDataSource(toDoDao)
    }

//    @Provides
//    @Singleton
//    fun provideToDoDao(@ApplicationContext context:Context):ToDoDao{
//
//    }


}