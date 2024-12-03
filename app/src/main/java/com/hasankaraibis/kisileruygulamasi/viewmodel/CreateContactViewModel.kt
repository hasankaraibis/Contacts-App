package com.hasankaraibis.kisileruygulamasi.viewmodel

import androidx.lifecycle.ViewModel
import com.hasankaraibis.kisileruygulamasi.repository.ContactsDaoRepository

class CreateContactViewModel: ViewModel() {
    private val repo = ContactsDaoRepository()

    fun save(contactName: String, contactNumber: String) {
        repo.saveContact(contactName, contactNumber)
    }

}