package ru.spb.altercom.yandexdiskserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import ru.spb.altercom.yandexdiskserver.entity.OAuthTokenProperties

@EnableConfigurationProperties(OAuthTokenProperties::class)
@SpringBootApplication
class YandexDiskServerApplication

fun main(args: Array<String>) {
	runApplication<YandexDiskServerApplication>(*args)
}
