package edu.itesm.stanley

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Actor(val photo:Int,
                 val name:String,
                 val movie:String,
                 val info:String) : Parcelable
