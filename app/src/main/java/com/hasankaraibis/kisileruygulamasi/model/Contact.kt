package com.hasankaraibis.kisileruygulamasi.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contact_id") var contactId: Int,
    @ColumnInfo(name = "contact_name") var contactName: String,
    @ColumnInfo(name = "contact_number") var contactNumber: String
) : Serializable {

}