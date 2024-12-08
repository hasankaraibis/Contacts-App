package com.hasankaraibis.kisileruygulamasi.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.hasankaraibis.kisileruygulamasi.repository.ContactsDaoRepository

class ContactDetailViewModel(application: Application): AndroidViewModel(application) {
    private val repo = ContactsDaoRepository(application)

    fun update(contactId: Int, contactName: String, contactNumber: String) {
        repo.updateContact(contactId, contactName, contactNumber)
    }
}