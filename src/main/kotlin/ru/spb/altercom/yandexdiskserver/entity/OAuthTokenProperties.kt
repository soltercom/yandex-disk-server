package ru.spb.altercom.yandexdiskserver.entity

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "oauth.token")
data class OAuthTokenProperties(
    val id: String,
    val password: String,
    val start_url: String,
    val callback_url: String
)
