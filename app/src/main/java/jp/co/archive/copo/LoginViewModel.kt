package jp.co.archive.copo

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginViewModel : ViewModel() {
    private val auth = Firebase.auth

    fun checkLogin() {
        // TODO: ログインチェック
        val user = auth.currentUser
    }
}