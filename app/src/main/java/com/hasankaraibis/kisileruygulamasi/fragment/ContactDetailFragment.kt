package com.hasankaraibis.kisileruygulamasi.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.hasankaraibis.kisileruygulamasi.R
import com.hasankaraibis.kisileruygulamasi.databinding.FragmentContactDetailBinding

class ContactDetailFragment : Fragment() {
    private lateinit var design: FragmentContactDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        design =
            DataBindingUtil.inflate(inflater, R.layout.fragment_contact_detail, container, false)
        design.contactDetailFragment = this
        design.contactDetailToolbarTitle = getString(R.string.contact_detail)

        val bundle: ContactDetailFragmentArgs by navArgs()
        val incomingContact = bundle.contact

        design.contact = incomingContact

        return design.root
    }

    fun btnUpdateClicked(contactId: Int, newName: String, newNumber: String) {
        Log.e(
            "Contact Updated",
            "Contact ID: $contactId, New Name: $newName, New Number: $newNumber"
        )
    }
}