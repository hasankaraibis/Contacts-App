package com.hasankaraibis.kisileruygulamasi.model

import java.io.Serializable

data class Contact(var contactId: Int, var contactName: String, var contactNumber: String) :
    Serializable {
}