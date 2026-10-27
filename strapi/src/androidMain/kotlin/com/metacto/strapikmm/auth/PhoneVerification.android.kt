package com.metacto.strapikmm.auth

import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import dev.gitlive.firebase.auth.PhoneVerificationProvider
import kotlinx.coroutines.CompletableDeferred

internal actual suspend fun sendPhoneVerificationCode(
    phoneNumber: String,
    verificationProvider: PhoneVerificationProvider
): PhoneVerificationMetadata {
    val result = CompletableDeferred<PhoneVerificationMetadata>()
    val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        override fun onCodeSent(verificationId: String, token: PhoneAuthProvider.ForceResendingToken) {
            result.complete(PhoneVerificationMetadata(verificationId, phoneNumber))
        }

        override fun onVerificationCompleted(credential: PhoneAuthCredential) = Unit

        override fun onVerificationFailed(error: FirebaseException) {
            result.completeExceptionally(error)
        }
    }
    val options = PhoneAuthOptions.newBuilder(FirebaseAuth.getInstance())
        .setPhoneNumber(phoneNumber)
        .setTimeout(verificationProvider.timeout, verificationProvider.unit)
        .setActivity(verificationProvider.activity)
        .setCallbacks(callbacks)
        .build()
    PhoneAuthProvider.verifyPhoneNumber(options)
    return result.await()
}
