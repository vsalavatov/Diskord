package com.jessecorbett.diskord.api.rest

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GroupDMAddRecipient(
    @SerialName("access_token") val accessToken: String,
    @SerialName("nick") val nickname: String
)
