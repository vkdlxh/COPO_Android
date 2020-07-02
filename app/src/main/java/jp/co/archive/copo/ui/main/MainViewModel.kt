package jp.co.archive.copo.ui.main

import androidx.lifecycle.ViewModel
import jp.co.archive.copo.data.model.Result
import jp.co.archive.copo.data.model.Event
import jp.co.archive.copo.data.repository.FirabaseRepository
import java.lang.Exception
import java.util.*

class MainViewModel(
        private val repository: FirabaseRepository
) : ViewModel() {

    val user = repository.user
    val progressBar = repository.progressBar

    fun logout() {
        repository.logout()
    }
}