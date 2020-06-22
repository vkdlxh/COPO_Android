package jp.co.archive.copo.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import jp.co.archive.copo.data.model.Room

class FirestoreRepository {

    private val db = FirebaseFirestore.getInstance()

    fun createRoom(room: Room) {
        db.collection("rooms").add(room).addOnCompleteListener {
            if (it.isSuccessful) {

            } else {
                // TODO: 失敗処理
            }
        }
    }

    fun getRoomList(adminId: String) {
        db.collection("rooms").whereEqualTo("adminId", adminId).get().addOnCompleteListener {
            if (it.isSuccessful) {
                val list = it.result?.toObjects(Room::class.java)

            } else {
                // TODO: 失敗処理
            }
        }
    }
}