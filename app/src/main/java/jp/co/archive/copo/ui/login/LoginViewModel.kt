package jp.co.archive.copo.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import jp.co.archive.copo.utils.extensions.isEmailValid
import jp.co.archive.copo.data.repository.FirabaseRepository

class LoginViewModel(
    private val repository: FirabaseRepository
) : ViewModel() {

    val user = repository.user
    val progressBar = repository.progressBar
    private val _errorMessage = repository.errorMessage
    val errorMessage: LiveData<String>
        get() = _errorMessage

    fun onClickLogin(email: String, password: String) {
        if (checkFormat(email, password)) {
            repository.login(email, password)
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