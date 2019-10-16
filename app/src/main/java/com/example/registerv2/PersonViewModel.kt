package com.example.registerv2

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PersonViewModel(application: Application): AndroidViewModel(application) {
    private val repo: PersonRepo
    val allPeople: LiveData<List<Person>>
    var numPeople: Int

    init {
        val personDao = PersonDB.getDatabase(
            application,
            viewModelScope
        ).personDao()
        repo = PersonRepo(personDao)
        allPeople = repo.allPeople
        numPeople = repo.numPeople
    }

    fun insert(person: Person) = viewModelScope.launch {
        repo.insert(person)
    }

    fun delete(person: Person) = viewModelScope.launch {
        repo.delete(person)
    }

    fun deleteAll() = viewModelScope.launch {
        repo.deleteAll()
    }
}