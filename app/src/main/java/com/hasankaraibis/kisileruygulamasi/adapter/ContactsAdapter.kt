package com.hasankaraibis.kisileruygulamasi.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.hasankaraibis.kisileruygulamasi.R
import com.hasankaraibis.kisileruygulamasi.databinding.ContactCardBinding
import com.hasankaraibis.kisileruygulamasi.fragment.MainScreenFragmentDirections
import com.hasankaraibis.kisileruygulamasi.model.Contact
import com.hasankaraibis.kisileruygulamasi.viewmodel.MainScreenViewModel

class ContactsAdapter(var mContext: Context, private var contactList: List<Contact>, var viewModel: MainScreenViewModel) :
    RecyclerView.Adapter<ContactsAdapter.CardDesignHolder>() {
    val TAG = "ContactsAdapter"

    inner class CardDesignHolder(var design: ContactCardBinding) :
        RecyclerView.ViewHolder(design.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design: ContactCardBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.contact_card, parent, false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val contact = contactList[position]
        holder.design.contact = contact

        holder.design.cardLine.setOnClickListener {
            val action = MainScreenFragmentDirections.navigateToContactDetail(contact)
            Navigation.findNavController(it).navigate(action)
        }

        holder.design.ivDeleteIcon.setOnClickListener { it ->
            Snackbar.make(
                it, "Do you really want to delete ${contact.contactName}",
                Snackbar.LENGTH_LONG
            )
                .setAction("YES") {
                    viewModel.delete(contact.contactId)
                    Log.e(TAG, "${contact.contactName} ${contact.contactId} deleted")
                }.show()
        }

    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}