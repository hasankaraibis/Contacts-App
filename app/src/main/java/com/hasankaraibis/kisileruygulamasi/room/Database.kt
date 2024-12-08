package com.hasankaraibis.kisileruygulamasi.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hasankaraibis.kisileruygulamasi.model.Contact

@Database(entities = [Contact::class], version = 1)
abstract class ContactsDatabase : RoomDatabase() {
    abstract fun contactsDao(): ContactsDao

    companion object {
        var INSTANCE: ContactsDatabase? = null

        fun accessDatabase(context: Context): ContactsDatabase? {
            if (INSTANCE == null) {
                synchronized(ContactsDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactsDatabase::class.java,
                        "contacts.sqlite"
                    ).createFromAsset("contacts.sqlite")
                        .build()
                }
            }
            return INSTANCE
        }
    }
}