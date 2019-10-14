package com.example.registerv2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Person::class], version = 1)
abstract class PersonDB: RoomDatabase(){
    abstract fun personDao(): PersonDao

    private class PersonDBCallback(
        private val scope: CoroutineScope
    ): RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let {database ->
                scope.launch {
                    var personDao = database.personDao()

                    personDao.deleteAll()

                    personDao.insert(Person(
                        id = 1,
                        firstName = "Avnish",
                        surname = "Desai"
                    ))

                    personDao.insert(Person(
                        id = 2,
                        firstName = "Aget",
                        surname = "P"
                    ))

                    personDao.insert(Person(
                        id = 3,
                        firstName = "Person",
                        surname = "3"
                    ))
                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: PersonDB? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
            ): PersonDB {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PersonDB::class.java,
                    "personDB"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}