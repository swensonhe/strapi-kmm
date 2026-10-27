package com.metacto.strapikmm.auth

import dev.gitlive.firebase.auth.PhoneVerificationProvider

data class PhoneVerificationMetadata(
    val verificationId: String,
    val phoneNumber: String
)

/**
 * Sends an SMS code to [phoneNumber] and returns once Firebase has issued the verification id.
 * The code itself is exchanged for a credential later, through `PhoneAuthProvider.credential`.
 */
internal expect suspend fun sendPhoneVerificationCode(
    phoneNumber: String,
    verificationProvider: PhoneVerificationProvider
): PhoneVerificationMetadata
