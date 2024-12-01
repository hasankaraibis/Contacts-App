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
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.hasankaraibis.kisileruygulamasi.R
import com.hasankaraibis.kisileruygulamasi.databinding.FragmentMainBinding
import com.hasankaraibis.kisileruygulamasi.model.Contact

class MainScreenFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var design: FragmentMainBinding
    private val TAG = "MainScreenFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        design = FragmentMainBinding.inflate(inflater, container, false)

        design.toolbarMainScreen.title = "Contacts"
        (activity as AppCompatActivity).setSupportActionBar(design.toolbarMainScreen)
        initMenu()

        design.fabAdd.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.navigateToCreateContact)
        }
        design.btnDetail.setOnClickListener {
            val contact = Contact(1, "hasan", "123")
            val action = MainScreenFragmentDirections.navigateToContactDetail(contact = contact)
            Navigation.findNavController(it).navigate(action)
        }

        return design.root
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
        search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        search(newText)
        return true
    }
    private fun search(query: String) {
        Log.e(TAG, "Search: $query")
    }
}