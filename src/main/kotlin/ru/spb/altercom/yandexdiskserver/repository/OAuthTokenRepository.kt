package ru.spb.altercom.yandexdiskserver.repository

import org.springframework.data.repository.Repository
import ru.spb.altercom.yandexdiskserver.entity.OAuthToken

interface OAuthTokenRepository: Repository<OAuthToken, Long> {

    fun save(token: OAuthToken)

}
