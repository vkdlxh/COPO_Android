package jp.co.archive.copo.ui.joinEvent

import android.content.Context
import android.content.Intent
import android.os.Bundle
import jp.co.archive.R
import jp.co.archive.copo.ui.base.BaseActivity
import jp.co.archive.databinding.ActivityJoinEventBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class JoinEventActivity : BaseActivity() {

    private val binding: ActivityJoinEventBinding by binding(R.layout.activity_join_event)
    private val joinEventViewModel: JoinEventViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this@JoinEventActivity
            viewModel = joinEventViewModel
        }
    }

    companion object {
        fun newInstance(context: Context) = Intent(context, JoinEventActivity::class.java)
    }
}