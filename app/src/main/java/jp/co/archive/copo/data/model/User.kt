package jp.co.archive.copo.data.model

import com.google.firebase.firestore.Exclude

data class User(
    val name: String = "",
    val phoneNumber: String = "",
    @get:Exclude
    var isAuthenticated: Boolean = false
)