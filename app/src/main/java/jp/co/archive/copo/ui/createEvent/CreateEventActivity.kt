package jp.co.archive.copo.ui.createEvent

import android.content.Context
import android.content.Intent
import android.os.Bundle
import jp.co.archive.R
import jp.co.archive.copo.ui.base.BaseActivity
import jp.co.archive.databinding.ActivityCreateEventBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateEventActivity : BaseActivity() {

    private val binding: ActivityCreateEventBinding by binding(R.layout.activity_create_event)
    private val createEventViewModel: CreateEventViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this@CreateEventActivity
            viewModel = createEventViewModel
        }
    }

    companion object {
        fun newInstance(context: Context) = Intent(context, CreateEventActivity::class.java)
    }
}