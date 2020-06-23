package jp.co.archive.copo.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import jp.co.archive.copo.data.model.Result
import jp.co.archive.copo.data.model.Room

class FirestoreRepository {

    private val db = FirebaseFirestore.getInstance()

    fun createRoom(room: Room, response: Result<Void?>) {
        db.collection("rooms")
            .add(room)
            .addOnSuccessListener {
                response.onSuccess(null)
            }.addOnFailureListener {
                response.onFailure(it)
            }
    }

    fun getRoomList(adminId: String, response: Result<List<Room>>) {
        db.collection("rooms").whereEqualTo("adminId", adminId)
            .get()
            .addOnSuccessListener {
                response.onSuccess(it.toObjects(Room::class.java))
            }.addOnFailureListener {
                response.onFailure(it)
            }
    }
}