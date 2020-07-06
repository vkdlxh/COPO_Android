package jp.co.archive.copo.ui.joinEvent

import androidx.lifecycle.ViewModel
import jp.co.archive.copo.data.model.Result
import jp.co.archive.copo.data.repository.FirabaseRepository
import java.lang.Exception

class JoinEventViewModel(
    private val repository: FirabaseRepository
) : ViewModel() {

    fun joinEvent(eventId: String) {
        repository.joinEvent(eventId, object : Result<Void?> {
            override fun onSuccess(response: Void?) {
                // TODO
            }

            override fun onFailure(e: Exception) {
                // TODO
            }
        })
    }
}