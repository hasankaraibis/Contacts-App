package com.hasankaraibis.kisileruygulamasi.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hasankaraibis.kisileruygulamasi.model.Contact
import com.hasankaraibis.kisileruygulamasi.repository.ContactsDaoRepository

class MainScreenViewModel: ViewModel() {
    val TAG = "MainScreenViewModel"
    val repo = ContactsDaoRepository()

    var contactList = MutableLiveData<List<Contact>>()

    init {
        loadContact()
        contactList = repo.getAllContacts()

    }

    fun search(keyword: String) {
        repo.searchContact(keyword)
    }

    fun delete(contactId: String) {
        repo.deleteContact(contactId)
    }

    fun loadContact() {
        repo.takeAllContacts()
    }
}