package jp.co.archive.copo.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import jp.co.archive.copo.utils.SingleLiveEvent
import jp.co.archive.copo.data.model.User

object AuthRepository {

    private val auth = Firebase.auth
    private val db = FirebaseFirestore.getInstance()
    private val usersCollection = db.collection("users")

    private val _user: MutableLiveData<User> = MutableLiveData()
    val user: LiveData<User>
        get() = _user
    var errorMessage: SingleLiveEvent<String> =
        SingleLiveEvent()

    // TODO:
    private val _progressBar: MutableLiveData<Boolean> = MutableLiveData()
    val progressBar: LiveData<Boolean>
        get() = _progressBar

    /*
     * ログイン中なのか確認
     */
    fun checkAuthenticated() {
        val user = auth.currentUser
        user?.let {
            getUserInfo(it.uid)
        } ?: run {
            _user.value = User(isAuthenticated = false)
        }
    }

    fun signUp(email: String, password: String, name: String, phone: String) {
        _progressBar.value = true
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                val uid = auth.currentUser?.uid ?: ""
                val newUser = User(name, phone)
                setUserInfo(uid, newUser)
            } else {
                it.exception?.let { exception ->
                    errorMessage.value = exception.localizedMessage
                }
            }
            _progressBar.value = false
        }
    }

    fun login(email: String, password: String) {
        _progressBar.value = true
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                val uid = auth.currentUser?.uid ?: ""
                getUserInfo(uid)
            } else {
                it.exception?.let { exception ->
                    errorMessage.value = exception.localizedMessage
                }
            }
            _progressBar.value = false
        }
    }

    fun logout() {
        auth.signOut()
        _user.value = User(isAuthenticated = false)
    }

    private fun getUserInfo(uid: String) {
        _progressBar.value = true
        usersCollection.document(uid).get().addOnCompleteListener {
            if (it.isSuccessful) {
                it.result?.let { snapshot ->
                    val user = snapshot.toObject(User::class.java)
                    user?.isAuthenticated = true
                    _user.value = user
                }
            } else {
                it.exception?.let { exception ->
                    errorMessage.value = exception.localizedMessage
                }
            }
            _progressBar.value = false
        }
    }

    private fun setUserInfo(uid: String, user: User) {
        _progressBar.value = true
        usersCollection.document(uid).set(user).addOnCompleteListener {
            if (it.isSuccessful) {
                user.isAuthenticated = true
                _user.value = user
            } else {
                it.exception?.let { exception ->
                    errorMessage.value = exception.localizedMessage
                }
            }
            _progressBar.value = false
        }
    }
}