package jp.co.archive.copo.ui.splash

import androidx.lifecycle.ViewModel
import jp.co.archive.copo.data.repository.FirabaseRepository

class SplashViewModel(
    private val repository: FirabaseRepository
) : ViewModel() {

    var user = repository.user

    fun checkAuthenticated() {
        repository.checkAuthenticated()
    }
}