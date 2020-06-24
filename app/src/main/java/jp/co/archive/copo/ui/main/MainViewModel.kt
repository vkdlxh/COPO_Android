package jp.co.archive.copo.ui.main

import androidx.lifecycle.ViewModel
import jp.co.archive.copo.data.model.Result
import jp.co.archive.copo.data.model.Event
import jp.co.archive.copo.data.repository.AuthRepository
import jp.co.archive.copo.data.repository.FirestoreRepository
import java.lang.Exception
import java.util.*

class MainViewModel(
    private val authRepository: AuthRepository,
    private val firestoreRepository: FirestoreRepository
) : ViewModel() {

    val user = authRepository.user
    val progressBar = authRepository.progressBar

    fun createRoom(title: String, description: String) {
        val event = Event("", title, description, Date())
        firestoreRepository.createRoom(event, object : Result<Void?> {
            override fun onSuccess(response: Void?) {
                TODO("Not yet implemented")
            }

            override fun onFailure(e: Exception) {
                TODO("Not yet implemented")
            }

        })
    }

    fun logout() {
        authRepository.logout()
    }
}