package jp.co.archive.copo.utils

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("android:visibility")
fun View.setVisibility(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("android:text")
fun TextView.text(date: Date) {
    val simpleDateFormat = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())
    text = simpleDateFormat.format(date)
}

@BindingAdapter("setAdapter")
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    this.run {
        this.adapter = adapter
    }
}