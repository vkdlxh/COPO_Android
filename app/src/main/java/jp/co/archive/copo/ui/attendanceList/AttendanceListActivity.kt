package jp.co.archive.copo.ui.attendanceList

import android.os.Bundle
import androidx.lifecycle.Observer
import jp.co.archive.R
import jp.co.archive.copo.ui.base.BaseActivity
import jp.co.archive.databinding.ActivityAttendanceListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AttendanceListActivity : BaseActivity() {

    private val binding: ActivityAttendanceListBinding by binding(R.layout.activity_attendance_list)
    private val attendanceListViewModel: AttendanceListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this@AttendanceListActivity
            viewModel = attendanceListViewModel
        }

        attendanceListViewModel.attendanceList.observe(this, Observer {
            // TODO: set recyclerView data
        })
        attendanceListViewModel.getAttendanceList()
    }
}