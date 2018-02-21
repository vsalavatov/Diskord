package com.jessecorbett.diskord.api.events

import com.fasterxml.jackson.annotation.JsonProperty

data class Hello(
        @JsonProperty("heartbeat_interval") val heartbeatInterval: Int,
        @JsonProperty("_trace") val trace: Array<String>
)
