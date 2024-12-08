package com.hasankaraibis.kisileruygulamasi.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.hasankaraibis.kisileruygulamasi.model.Contact

class ContactsDaoRepository {
    val TAG = "ContactsDaoRepository"

    var contactList: MutableLiveData<List<Contact>> = MutableLiveData()

    var refContacts: DatabaseReference = FirebaseDatabase.getInstance().getReference("contacts")

    fun getAllContacts(): MutableLiveData<List<Contact>> {
        return contactList
    }

    fun saveContact(contactName: String, contactNumber: String) {
        val contact = Contact("", contactName, contactNumber)
        refContacts.push().setValue(contact)
    }

    fun updateContact(contactId: String, newName: String, newNumber: String) {
        val info = HashMap<String, Any>()
        info["contactName"] = newName
        info["contactNumber"] = newNumber
        refContacts.child(contactId).updateChildren(info)
    }

    fun searchContact(keyword: String) {
        refContacts.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = ArrayList<Contact>()
                for (c in snapshot.children) {
                    val contact = c.getValue(Contact::class.java)
                    if (contact != null) {
                        if (contact.contactName!!.lowercase().contains(keyword.lowercase())) {
                            contact.contactId = c.key
                            list.add(contact)
                        }
                    }
                }
                contactList.value = list
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

    fun deleteContact(contactId: String) {
        refContacts.child(contactId).removeValue()
    }

    fun takeAllContacts() {
        refContacts.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = ArrayList<Contact>()
                for (c in snapshot.children) {
                    val contact = c.getValue(Contact::class.java)
                    if (contact != null) {
                        contact.contactId = c.key
                        list.add(contact)
                    }
                }
                contactList.value = list
            }

            override fun onCancelled(error: DatabaseError) { }
        })
    }
}