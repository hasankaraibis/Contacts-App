package com.hasankaraibis.kisileruygulamasi.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.hasankaraibis.kisileruygulamasi.model.Contact

@Dao
interface ContactsDao {
    @Query("SELECT * FROM contacts")
    suspend fun getAllContacts(): List<Contact>

    @Insert
    suspend fun saveContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contacts WHERE contact_name like '%' || :keyword || '%'")
    suspend fun searchContact(keyword: String): List<Contact>

}