package com.hasankaraibis.kisileruygulamasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.hasankaraibis.kisileruygulamasi.databinding.FragmentMainBinding

class MainScreenFragment : Fragment() {
    private lateinit var design: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        design = FragmentMainBinding.inflate(inflater, container, false)

        design.toolbarMainScreen.title = "Contacts"

        design.fabAdd.setOnClickListener {
//            val gecis = MainScreenFragmentDirections.mainToCreate()
//            Navigation.findNavController(it).navigate(gecis)
            Snackbar.make(it, "Add button clicked", Snackbar.LENGTH_SHORT).show()
        }

        return design.root
    }

}