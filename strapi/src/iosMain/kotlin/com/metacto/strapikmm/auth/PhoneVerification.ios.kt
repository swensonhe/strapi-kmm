package com.metacto.strapikmm.auth

import cocoapods.FirebaseAuth.FIRPhoneAuthProvider
import dev.gitlive.firebase.auth.PhoneVerificationProvider
import kotlinx.cinterop.ExperimentalForeignApi
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

@OptIn(ExperimentalForeignApi::class)
internal actual suspend fun sendPhoneVerificationCode(
    phoneNumber: String,
    verificationProvider: PhoneVerificationProvider
): PhoneVerificationMetadata {
    val provider = FIRPhoneAuthProvider.provider()
    val verificationId = suspendCoroutine<String> { continuation ->
        provider.verifyPhoneNumber(phoneNumber, null) { verificationId, error ->
            when {
                error != null -> continuation.resumeWithException(IllegalStateException(error.localizedDescription))
                verificationId != null -> continuation.resume(verificationId)
                else -> continuation.resumeWithException(IllegalStateException("Firebase returned no verification id"))
            }
        }
    }
    return PhoneVerificationMetadata(verificationId, phoneNumber)
}
