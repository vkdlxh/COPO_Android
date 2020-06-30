package jp.co.archive.copo.ui.createEvent

import androidx.lifecycle.ViewModel
import jp.co.archive.copo.data.model.Result
import jp.co.archive.copo.data.repository.FirabaseRepository

class CreateEventViewModel(
    private val repository: FirabaseRepository
) : ViewModel() {

    fun createEvent(title: String, description: String) {
        repository.createEvent(title, description, object : Result<Void?> {
            override fun onSuccess(response: Void?) {

            }

            override fun onFailure(e: Exception) {

            }

        })
    }
}