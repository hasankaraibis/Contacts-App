package com.hasankaraibis.kisileruygulamasi.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.hasankaraibis.kisileruygulamasi.R
import com.hasankaraibis.kisileruygulamasi.adapter.ContactsAdapter
import com.hasankaraibis.kisileruygulamasi.databinding.FragmentMainBinding
import com.hasankaraibis.kisileruygulamasi.model.Contact
import com.hasankaraibis.kisileruygulamasi.repository.ContactsDaoRepository
import com.hasankaraibis.kisileruygulamasi.viewmodel.MainScreenVMF
import com.hasankaraibis.kisileruygulamasi.viewmodel.MainScreenViewModel

class MainScreenFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var design: FragmentMainBinding
    private lateinit var viewModel: MainScreenViewModel
    private val TAG = "MainScreenFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        design.mainScreenFragment = this
        design.mainScreenToolbarTitle = "Contacts"
        (activity as AppCompatActivity).setSupportActionBar(design.toolbarMainScreen)
        initMenu()

        viewModel.contactList.observe(viewLifecycleOwner) { contactList ->
            val adapter = ContactsAdapter(requireContext(), contactList, viewModel)
            design.contactsAdapter = adapter
        }

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainScreenViewModel by viewModels(){
            MainScreenVMF(requireActivity().application)
        }
        viewModel = tempViewModel
    }


    private fun initMenu() {
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu)

                val item = menu.findItem(R.id.menuItemSearch)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@MainScreenFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.menuItemSearch -> {
                        Log.e(TAG, "Search")
                        true
                    }

                    R.id.menuItemSettings -> {
                        Log.e(TAG, "Settings")
                        true
                    }

                    else -> false
                }
            }
        })
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
        return true
    }

    fun fabClick(view: View) {
        Navigation.findNavController(view).navigate(R.id.navigateToCreateContact)
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadContact()
    }
}