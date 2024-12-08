package com.hasankaraibis.kisileruygulamasi.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.hasankaraibis.kisileruygulamasi.repository.ContactsDaoRepository

class CreateContactViewModel(application: Application): AndroidViewModel(application) {
    private val repo = ContactsDaoRepository(application)

    fun save(contactName: String, contactNumber: String) {
        repo.saveContact(contactName, contactNumber)
    }

}