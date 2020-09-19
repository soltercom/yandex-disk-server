package ru.spb.altercom.yandexdiskserver.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "oAuthToken")
data class OAuthToken(
    @Column(name = "token_type")
    val token_type: String,

    @Id @Column(name = "access_token")
    val access_token: String,

    @Column(name = "expires_in")
    val expires_in: Long,

    @Column(name = "refresh_token")
    val refresh_token: String)
