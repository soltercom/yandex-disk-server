package ru.spb.altercom.yandexdiskserver.repository

import org.springframework.data.repository.Repository
import org.springframework.transaction.annotation.Transactional
import ru.spb.altercom.yandexdiskserver.entity.User

interface UserRepository: Repository<User, Long> {

    @Transactional(readOnly = true)
    fun findAll(): Collection<User>

    @Transactional(readOnly = true)
    fun findUserByPin(pin: String): User?
}
