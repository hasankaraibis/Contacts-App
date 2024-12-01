package com.hasankaraibis.kisileruygulamasi.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hasankaraibis.kisileruygulamasi.databinding.FragmentCreateContactBinding

class CreateContactFragment : Fragment() {
    private lateinit var design: FragmentCreateContactBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        design = FragmentCreateContactBinding.inflate(inflater, container, false)
        design.toolbarCreateContact.title = "New Contact"

        design.btnSave.setOnClickListener {
            val contactName = design.edtPersonName.text.toString()
            val contactNumber = design.edtPersonNumber.text.toString()

            createContact(contactName, contactNumber)
        }

        return design.root
    }
    private fun createContact(contactName: String, contactNumber: String) {
        Log.e("Create Contact", "$contactName - $contactNumber")
    }
}