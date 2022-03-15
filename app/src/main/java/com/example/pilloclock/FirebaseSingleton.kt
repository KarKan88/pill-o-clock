package com.example.pilloclock

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

object FirebaseSingleton {
    var auth: FirebaseAuth

    init {
        auth = FirebaseAuth.getInstance()
    }

    fun SignUpUser(email: String, password: String): String {
        var result = ""
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if(it.isSuccessful) {
                result = "Successfully created account"
            }
            else {
                result = "Unable to create account. %s".format(it.exception)
            }
        }
        return result
    }

    fun LoginUser(email: String, password: String): String {
        var result = ""
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if(it.isSuccessful) {
                result = "Successfully logged in"
            }
            else {
                result = "Unable to log in. %s".format(it.exception)
            }
        }
        return result
    }
}
