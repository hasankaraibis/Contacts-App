package com.hasankaraibis.kisileruygulamasi.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.hasankaraibis.kisileruygulamasi.model.Contact
import com.hasankaraibis.kisileruygulamasi.repository.ContactsDaoRepository

class MainScreenViewModel(application: Application) : AndroidViewModel(application) {
    val TAG = "MainScreenViewModel"
    val repo = ContactsDaoRepository(application)
    var contactList = MutableLiveData<List<Contact>>()

    init {
        loadContact()
        contactList = repo.getAllContacts()

    }

    fun search(keyword: String) {
        repo.searchContact(keyword)
    }

    fun delete(contactId: Int) {
        repo.deleteContact(contactId)
    }

    fun loadContact() {
        repo.takeAllContacts()
    }
}