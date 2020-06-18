package jp.co.archive.copo.ui.splash

import androidx.lifecycle.ViewModel
import jp.co.archive.copo.data.repository.AuthRepository

class SplashViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {

    var user = authRepository.user

    fun checkAuthenticated() {
        authRepository.checkAuthenticated()
    }
}