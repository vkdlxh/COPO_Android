package jp.co.archive.copo.ui.eventList

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.EventLog
import androidx.recyclerview.widget.LinearLayoutManager
import jp.co.archive.R
import jp.co.archive.copo.data.model.Event
import jp.co.archive.copo.ui.base.BaseActivity
import jp.co.archive.databinding.ActivityEventListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class EventListActivity : BaseActivity() {

    private val binding: ActivityEventListBinding by binding(R.layout.activity_event_list)
    private val eventListViewModel: EventListViewModel by viewModel()

    private lateinit var adapter: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = EventAdapter(
            listOf(
                Event("123", "test title1", "test description1", Date())
            )
        )
        binding.apply {
            lifecycleOwner = this@EventListActivity
            viewModel = eventListViewModel
            adapter = this@EventListActivity.adapter
        }

    }

    companion object {
        fun newInstance(context: Context) = Intent(context, EventListActivity::class.java)
    }
}