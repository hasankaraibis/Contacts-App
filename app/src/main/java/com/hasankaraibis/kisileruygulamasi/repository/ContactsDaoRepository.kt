package com.hasankaraibis.kisileruygulamasi.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.hasankaraibis.kisileruygulamasi.model.Contact
import com.hasankaraibis.kisileruygulamasi.room.ContactsDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactsDaoRepository(application: Application) {
    val TAG = "ContactsDaoRepository"
    var contactList: MutableLiveData<List<Contact>> = MutableLiveData()
    var db: ContactsDatabase = ContactsDatabase.accessDatabase(application)!!

    fun getAllContacts() : MutableLiveData<List<Contact>>  {
        return contactList
    }

    fun saveContact(contactName: String, contactNumber: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val newContact = Contact(0, contactName, contactNumber)
            db.contactsDao().saveContact(newContact)
        }
    }

    fun updateContact(contactId: Int, newName: String, newNumber: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val updatedContact = Contact(contactId, newName, newNumber)
            db.contactsDao().updateContact(updatedContact)
        }
    }

    fun searchContact(keyword: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            contactList.value = db.contactsDao().searchContact(keyword)
        }
    }

    fun deleteContact(contactId: Int) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val deletedContact = Contact(contactId, "", "")
            db.contactsDao().deleteContact(deletedContact)
            takeAllContacts()
        }
    }

    fun takeAllContacts() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            contactList.value = db.contactsDao().getAllContacts()
        }
    }
}