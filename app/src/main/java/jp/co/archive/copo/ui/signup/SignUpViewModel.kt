package jp.co.archive.copo.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import jp.co.archive.copo.utils.extensions.isEmailValid
import jp.co.archive.copo.data.repository.FirabaseRepository

class SignUpViewModel(
    private val repository: FirabaseRepository
) : ViewModel() {

    val user = repository.user
    val progressBar = repository.progressBar
    private val _errorMessage = repository.errorMessage
    val errorMessage: LiveData<String>
        get() = _errorMessage

    fun onClickSignUp(email: String, password: String, name: String, phone: String) {
        if (checkFormat(email, password, name, phone)) {
            repository.signUp(email, password, name, phone)
        }
    }

    private fun checkFormat(email: String, password: String, name: String, phone: String): Boolean {
        return if (!email.isEmailValid()) {
            _errorMessage.value = "正しいメールを入力してください"
            false
        } else if (password.length < 6) {
            _errorMessage.value = "パスワードは６文字です"
            false
        } else if (name.isEmpty()) {
            _errorMessage.value = "名前を入力してください"
            false
        } else if (phone.isEmpty()) {
            _errorMessage.value = "携帯電話を入力してください"
            false
        } else {
            true
        }
    }
}