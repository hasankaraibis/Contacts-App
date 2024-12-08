package com.hasankaraibis.kisileruygulamasi.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hasankaraibis.kisileruygulamasi.databinding.FragmentCreateContactBinding
import com.hasankaraibis.kisileruygulamasi.viewmodel.CreateContactVMF
import com.hasankaraibis.kisileruygulamasi.viewmodel.CreateContactViewModel

class CreateContactFragment : Fragment() {
    private lateinit var design: FragmentCreateContactBinding
    private lateinit var viewModel: CreateContactViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        design = FragmentCreateContactBinding.inflate(inflater, container, false)
        design.createContactFragment = this
        design.createContactToolbarTitle = "New Contact"


        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: CreateContactViewModel by viewModels(){
            CreateContactVMF(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    fun btnSaveClick(contactName: String, contactNumber: String) {
        viewModel.save(contactName, contactNumber)
    }
}