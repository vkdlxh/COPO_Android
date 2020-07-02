package jp.co.archive.copo.ui.eventList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jp.co.archive.copo.data.model.Event
import jp.co.archive.copo.data.model.Result
import jp.co.archive.copo.data.repository.FirabaseRepository
import java.lang.Exception

class EventListViewModel(
        private val repository: FirabaseRepository
) : ViewModel() {
    private val _eventList: MutableLiveData<List<Event>> = MutableLiveData()
    val eventList: LiveData<List<Event>>
        get() = _eventList

    fun getEventList() {
        repository.getEventList(object : Result<List<Event>> {
            override fun onSuccess(response: List<Event>) {
                _eventList.value = response
            }

            override fun onFailure(e: Exception) {
                TODO("Not yet implemented")
            }

        })
    }
}