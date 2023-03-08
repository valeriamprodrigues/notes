package com.valeriamprodrigues.notes.domain.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Note(
    val id: String = "",
    val title: String = "",
    val text: String = ""
) : Parcelable
