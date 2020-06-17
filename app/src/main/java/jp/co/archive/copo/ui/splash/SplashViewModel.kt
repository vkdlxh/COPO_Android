package jp.co.archive.copo.ui.splash

import androidx.lifecycle.ViewModel
import jp.co.archive.copo.data.repository.AuthRepository

class SplashViewModel : ViewModel() {
    private val authRepository = AuthRepository
    var user = authRepository.user

    fun checkAuthenticated() {
        authRepository.checkAuthenticated()
    }
}