package com.example.tp2ihm.bo

import android.os.Parcel
import android.os.Parcelable

data class PlanetList (
    val count: Int
        ) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(count)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlanetList> {
        override fun createFromParcel(parcel: Parcel): PlanetList {
            return PlanetList(parcel)
        }

        override fun newArray(size: Int): Array<PlanetList?> {
            return arrayOfNulls(size)
        }
    }
}