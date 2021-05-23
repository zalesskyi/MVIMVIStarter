package com.example.mvistarter.data.api

import com.google.firebase.auth.FirebaseAuth
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

interface AuthApi {

    suspend fun signIn(email: String, password: String): Boolean
}

class AuthApiImpl : AuthApi {

    override suspend fun signIn(email: String, password: String): Boolean =
        suspendCoroutine { cont ->
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener {
                cont.resume(it.isSuccessful)
            }
        }
}