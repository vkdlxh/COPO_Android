package jp.co.archive.copo.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import jp.co.archive.copo.utils.extensions.isEmailValid
import jp.co.archive.copo.data.repository.AuthRepository

class LoginViewModel : ViewModel() {

    private val authRepository = AuthRepository
    val user = authRepository.user
    val progressBar = authRepository.progressBar
    private val _errorMessage = authRepository.errorMessage
    val errorMessage: LiveData<String>
        get() = _errorMessage

    fun onClickLogin(email: String, password: String) {
        if (checkFormat(email, password)) {
            authRepository.login(email, password)
        }
    }

    private fun checkFormat(email: String, password: String): Boolean {
        return if (!email.isEmailValid()) {
            _errorMessage.value = "正しいメールを入力してください"
            false
        } else if (password.length < 6) {
            _errorMessage.value = "パスワードは６文字です"
            false
        } else {
            true
        }
    }
}