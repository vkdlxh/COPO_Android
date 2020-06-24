package jp.co.archive.copo.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import jp.co.archive.copo.data.model.Result
import jp.co.archive.copo.data.model.Event

class FirestoreRepository {

    private val db = FirebaseFirestore.getInstance()

    fun createRoom(event: Event, response: Result<Void?>) {
        db.collection("rooms")
            .add(event)
            .addOnSuccessListener {
                response.onSuccess(null)
            }.addOnFailureListener {
                response.onFailure(it)
            }
    }

    fun getRoomList(adminId: String, response: Result<List<Event>>) {
        db.collection("rooms").whereEqualTo("adminId", adminId)
            .get()
            .addOnSuccessListener {
                response.onSuccess(it.toObjects(Event::class.java))
            }.addOnFailureListener {
                response.onFailure(it)
            }
    }
}