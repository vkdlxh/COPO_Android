package jp.co.archive.copo.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import jp.co.archive.R
import jp.co.archive.copo.ui.attendanceList.AttendanceListActivity
import jp.co.archive.copo.ui.base.BaseActivity
import jp.co.archive.copo.ui.createEvent.CreateEventActivity
import jp.co.archive.copo.ui.eventList.EventListActivity
import jp.co.archive.copo.ui.joinEvent.JoinEventActivity
import jp.co.archive.copo.ui.login.LoginActivity
import jp.co.archive.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this@MainActivity
            viewModel = this@MainActivity.viewModel
            activity = this@MainActivity
        }

        viewModel.user.observe(this, Observer {
            if (!it.isAuthenticated) {
                startActivity(LoginActivity.newInstance(this))
                finish()
            }
        })
    }

    fun showEventList() {
        startActivity(EventListActivity.newInstance(this))
    }

    fun showCreateEvent() {
        startActivity(CreateEventActivity.newInstance(this))
    }

    fun showJoinEventList() {
        startActivity(AttendanceListActivity.newInstance(this))
    }

    fun showJoinEvent() {
        startActivity(JoinEventActivity.newInstance(this))
    }

    companion object {
        fun newInstance(context: Context) = Intent(context, MainActivity::class.java)
    }
}