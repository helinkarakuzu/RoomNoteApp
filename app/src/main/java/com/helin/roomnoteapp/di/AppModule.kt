package com.helin.roomnoteapp.di

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Room
import com.helin.roomnoteapp.data.datasource.NoteDataSource
import com.helin.roomnoteapp.data.repo.NoteRepo
import com.helin.roomnoteapp.room.Database
import com.helin.roomnoteapp.room.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesNoteDataSource(noteDao: NoteDao) : NoteDataSource{
        return NoteDataSource(noteDao)
    }

    @Provides
    @Singleton
    fun providesNoteRepo(nds : NoteDataSource) : NoteRepo {
        return NoteRepo(nds)
    }

    @Provides
    @Singleton
    fun providesNoteDao(@ApplicationContext context: Context) : NoteDao {
        val db = Room.databaseBuilder(context , Database :: class.java , "notes").build()
        return db.getNotesDao()

    }
}