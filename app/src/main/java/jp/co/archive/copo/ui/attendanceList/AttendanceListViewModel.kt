package jp.co.archive.copo.ui.attendanceList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jp.co.archive.copo.data.model.Attendance
import jp.co.archive.copo.data.model.Result
import jp.co.archive.copo.data.repository.FirabaseRepository
import java.lang.Exception

class AttendanceListViewModel(
    private val repository: FirabaseRepository
) : ViewModel() {

    private val _attendanceList = MutableLiveData<List<Attendance>>()
    val attendanceList: LiveData<List<Attendance>>
        get() = _attendanceList

    fun getAttendanceList() {
        repository.getAttendanceList(object : Result<List<Attendance>> {
            override fun onSuccess(response: List<Attendance>) {
                _attendanceList.value = response
            }

            override fun onFailure(e: Exception) {
                TODO("Not yet implemented")
            }

        })
    }
}