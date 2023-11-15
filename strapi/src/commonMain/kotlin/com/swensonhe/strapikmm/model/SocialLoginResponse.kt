package com.swensonhe.strapikmm.model

import com.swensonhe.strapikmm.auth.ProfileMetadata
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class SocialLoginResponse<T>(
    @SerialName("user")
    val user: T,
    @SerialName("metadata")
    val metadata: ProfileMetadata?,
)