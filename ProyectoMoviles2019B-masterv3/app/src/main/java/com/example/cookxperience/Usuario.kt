package com.example.examenapplication

import android.os.Parcel
import android.os.Parcelable

class Usuario(
    var id:Int,
    var nombreUsuario:String,
    var mail: String,
    var usernameUsuario:String,
    var clave: String):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString() ,
        parcel.readString().toString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nombreUsuario)
        parcel.writeString(mail)
        parcel.writeString(usernameUsuario)
        parcel.writeString(clave)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Usuario> {
        override fun createFromParcel(parcel: Parcel): Usuario {
            return Usuario(parcel)
        }

        override fun newArray(size: Int): Array<Usuario?> {
            return arrayOfNulls(size)
        }
    }

}