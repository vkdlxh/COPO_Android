package jp.co.archive.copo.ui.main

import androidx.lifecycle.ViewModel
import jp.co.archive.copo.data.repository.AuthRepository
import jp.co.archive.copo.data.repository.FirestoreRepository

class MainViewModel(
    private val authRepository: AuthRepository,
    private val firestoreRepository: FirestoreRepository
) : ViewModel() {

    val user = authRepository.user
    val progressBar = authRepository.progressBar

    fun logout() {
        authRepository.logout()
    }
}