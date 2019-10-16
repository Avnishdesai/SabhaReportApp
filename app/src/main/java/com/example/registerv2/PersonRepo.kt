package com.example.registerv2

import androidx.lifecycle.LiveData

class PersonRepo(private val personDao: PersonDao){
    val allPeople: LiveData<List<Person>> = personDao.getAllPeople()
    val numPeople: Int = personDao.getNumPeople()

    suspend fun insert(person: Person) {
        personDao.insert(person)
    }

    suspend fun delete(person: Person) {
        personDao.delete(person)
    }

    suspend fun deleteAll() {
        personDao.deleteAll()
    }

}