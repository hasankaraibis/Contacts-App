package com.hasankaraibis.kisileruygulamasi.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.hasankaraibis.kisileruygulamasi.databinding.FragmentContactDetailBinding

class ContactDetailFragment : Fragment() {
    private lateinit var design: FragmentContactDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        design = FragmentContactDetailBinding.inflate(inflater, container, false)

        val bundle: ContactDetailFragmentArgs by navArgs()
        val incomingContact = bundle.contact

        design.edtPersonName.setText(incomingContact.contactName)
        design.edtPersonNumber.setText(incomingContact.contactNumber)

        design.btnUpdate.setOnClickListener {
            val newName = design.edtPersonName.text.toString()
            val newNumber = design.edtPersonNumber.text.toString()
            updateContact(incomingContact.contactId, newName, newNumber)
        }

        return design.root
    }

    private fun updateContact(contactId: Int, newName: String, newNumber: String) {
    Log.e("Contact Updated", "Contact ID: $contactId, New Name: $newName, New Number: $newNumber")
    }
}