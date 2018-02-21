package com.jessecorbett.diskord.api.events

import com.fasterxml.jackson.annotation.JsonProperty
import com.jessecorbett.diskord.api.models.User
import java.time.ZonedDateTime

data class GuildMemberAdd(
        @JsonProperty("user") val user: User,
        @JsonProperty("nick") val nickname: String? = null,
        @JsonProperty("roles") val roleIds: Array<String>,
        @JsonProperty("joined_at") val joinedAt: ZonedDateTime,
        @JsonProperty("deaf") val isDeaf: Boolean,
        @JsonProperty("mute") val isMute: Boolean,
        @JsonProperty("guild_id") val guildId: String
)
