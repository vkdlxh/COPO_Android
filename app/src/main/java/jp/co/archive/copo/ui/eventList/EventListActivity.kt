package jp.co.archive.copo.ui.eventList

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import jp.co.archive.R
import jp.co.archive.copo.ui.base.BaseActivity
import jp.co.archive.databinding.ActivityEventListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventListActivity : BaseActivity() {

    private val binding: ActivityEventListBinding by binding(R.layout.activity_event_list)
    private val eventListViewModel: EventListViewModel by viewModel()

    private val adapter = EventAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this@EventListActivity
            viewModel = eventListViewModel
            adapter = this@EventListActivity.adapter
        }

        eventListViewModel.eventList.observe(this, Observer {
            adapter.replaceEventList(it)
        })
        eventListViewModel.getEventList()
    }

    companion object {
        fun newInstance(context: Context) = Intent(context, EventListActivity::class.java)
    }
}