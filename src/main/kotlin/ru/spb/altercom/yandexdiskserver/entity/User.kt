package ru.spb.altercom.yandexdiskserver.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue
    val id: Long,

    @Column(name = "name")
    val name: String,

    @JsonIgnore
    @Column(name = "pin")
    val pin: String
)
