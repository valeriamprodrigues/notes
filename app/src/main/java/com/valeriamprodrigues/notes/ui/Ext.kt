package com.valeriamprodrigues.notes.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

fun TextView.visible() {
  this.visibility = View.VISIBLE
}
fun TextView.gone() {
    this.visibility = View.GONE
}
fun RecyclerView.visible() {
    this.visibility = View.VISIBLE
}
fun RecyclerView.invisible() {
    this.visibility = View.INVISIBLE
}