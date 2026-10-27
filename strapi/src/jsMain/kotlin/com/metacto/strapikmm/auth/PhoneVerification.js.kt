package com.metacto.strapikmm.auth

import dev.gitlive.firebase.auth.PhoneVerificationProvider

internal actual suspend fun sendPhoneVerificationCode(
    phoneNumber: String,
    verificationProvider: PhoneVerificationProvider
): PhoneVerificationMetadata = throw UnsupportedOperationException("Phone verification is not supported on JS")
