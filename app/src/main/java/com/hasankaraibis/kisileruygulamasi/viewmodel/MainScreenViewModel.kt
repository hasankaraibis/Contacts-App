package com.hasankaraibis.kisileruygulamasi.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.hasankaraibis.kisileruygulamasi.repository.ContactsDaoRepository

class MainScreenViewModel: ViewModel() {
    val TAG = "MainScreenViewModel"
    val repo = ContactsDaoRepository()

    fun search(keyword: String) {
        repo.searchContact(keyword)
    }

    fun delete(contactId: Int) {
        repo.deleteContact(contactId)
    }
}