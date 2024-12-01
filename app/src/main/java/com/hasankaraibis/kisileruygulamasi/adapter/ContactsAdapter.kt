package com.hasankaraibis.kisileruygulamasi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasankaraibis.kisileruygulamasi.R
import com.hasankaraibis.kisileruygulamasi.databinding.ContactCardBinding
import com.hasankaraibis.kisileruygulamasi.model.Contact

class ContactsAdapter(var mContext: Context, private var contactList: List<Contact>) :
    RecyclerView.Adapter<ContactsAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var design: ContactCardBinding) : RecyclerView.ViewHolder(design.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = ContactCardBinding.inflate(layoutInflater, parent, false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val contact = contactList[position]
        holder.design.tvContactInfo.text = holder.itemView.context
            .getString(R.string.contact_info, contact.contactName, contact.contactNumber)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}