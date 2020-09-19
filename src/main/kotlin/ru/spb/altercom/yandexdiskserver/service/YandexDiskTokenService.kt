package ru.spb.altercom.yandexdiskserver.service

import org.springframework.http.*
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestTemplate
import ru.spb.altercom.yandexdiskserver.entity.OAuthToken
import ru.spb.altercom.yandexdiskserver.entity.OAuthTokenProperties

@Service
class YandexDiskTokenService(private val properties: OAuthTokenProperties) {

    fun prepareTokenRequest(code: Int): HttpEntity<LinkedMultiValueMap<String, String>> {
        val map = LinkedMultiValueMap<String, String>()
        map.add("grant_type", "authorization_code")
        map.add("code", code.toString())
        map.add("client_id", properties.id)
        map.add("client_secret", properties.password)

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_FORM_URLENCODED

        return HttpEntity(map, headers)
    }


    fun exchangeCode(code: Int): OAuthToken? {
        val url = "https://oauth.yandex.ru/token"
        val result = RestTemplate().exchange(url, HttpMethod.POST, prepareTokenRequest(code), OAuthToken::class.java)
        return result?.body
    }

}
