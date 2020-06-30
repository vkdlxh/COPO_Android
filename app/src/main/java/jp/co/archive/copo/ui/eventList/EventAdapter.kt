package jp.co.archive.copo.ui.eventList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.co.archive.copo.data.model.Event
import jp.co.archive.databinding.ItemEventBinding

class EventAdapter(
    private var eventList: List<Event> = emptyList()
) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEventBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = eventList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindView(eventList[position])

    fun replaceEventList(list: List<Event>) {
        eventList = list
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemEventBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(event: Event) {
            binding.item = event
            binding.executePendingBindings()
        }
    }
}