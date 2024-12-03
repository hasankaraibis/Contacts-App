package com.hasankaraibis.kisileruygulamasi.viewmodel

import androidx.lifecycle.ViewModel
import com.hasankaraibis.kisileruygulamasi.repository.ContactsDaoRepository

class ContactDetailViewModel: ViewModel() {
    private val repo = ContactsDaoRepository()

    fun update(contactId: Int, contactName: String, contactNumber: String) {
        repo.updateContact(contactId, contactName, contactNumber)
    }
}