package com.doovj.futbalclab

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Clab (val namaklab : String?,
                 val gambarklab : Int?,
                 val deskripsiklab : String?) : Parcelable