package jp.co.archive.copo.ui.main

import androidx.lifecycle.ViewModel
import jp.co.archive.copo.data.repository.AuthRepository

class MainViewModel : ViewModel() {

    private val authRepository = AuthRepository
    val user = authRepository.user
    val progressBar = authRepository.progressBar

    fun logout() {
        authRepository.logout()
    }
}