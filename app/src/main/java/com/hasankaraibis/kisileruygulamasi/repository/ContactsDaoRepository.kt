package com.hasankaraibis.kisileruygulamasi.repository

import android.util.Log

class ContactsDaoRepository {
    val TAG = "ContactsDaoRepository"

    fun saveContact(contactName: String, contactNumber: String) {
        Log.e(TAG, "$contactName - $contactNumber")
    }

    fun updateContact(contactId: Int, newName: String, newNumber: String) {
        Log.e(TAG,"Contact ID: $contactId, New Name: $newName, New Number: $newNumber")
    }
}