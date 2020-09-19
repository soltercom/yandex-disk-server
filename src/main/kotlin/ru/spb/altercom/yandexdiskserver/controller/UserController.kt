package ru.spb.altercom.yandexdiskserver.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ru.spb.altercom.yandexdiskserver.repository.UserRepository

@CrossOrigin
@RestController
class UserController(private val userRepository: UserRepository) {

    @GetMapping("/users")
    fun getUsers()
        = userRepository.findAll()

    @GetMapping("/users/pin/{pin}")
    fun getUser(@PathVariable pin: String)
        = userRepository.findUserByPin(pin)

}
