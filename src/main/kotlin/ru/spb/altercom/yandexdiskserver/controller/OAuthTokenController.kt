package ru.spb.altercom.yandexdiskserver.controller

import org.springframework.web.bind.annotation.*
import ru.spb.altercom.yandexdiskserver.entity.OAuthTokenProperties
import ru.spb.altercom.yandexdiskserver.repository.OAuthTokenRepository
import ru.spb.altercom.yandexdiskserver.service.YandexDiskTokenService

@RestController
class OAuthTokenController(private val yandexDiskToken: YandexDiskTokenService,
                           private val tokenRepository: OAuthTokenRepository) {

    // https://oauth.yandex.ru/authorize?response_type=code&client_id=c1fff6a9dffd40f6b560ede079cfbb0c
    @GetMapping("/yandex.disk.api/update-oauth-token")
    fun updateOAuthToken(@RequestParam("code") code: Int) {
        val token = yandexDiskToken.exchangeCode(code) ?: return
        tokenRepository.save(token)
    }

}
