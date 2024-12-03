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
        design.createContactFragment = this
        design.createContactToolbarTitle = "New Contact"


        return design.root
    }

    fun btnSaveClick(contactName: String, contactNumber: String) {
        Log.e("Create Contact", "$contactName - $contactNumber")
    }
}