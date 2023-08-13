package com.asacsm.Dockerizing.a.Spring.Boot.by.selene.controller

import com.asacsm.Dockerizing.a.Spring.Boot.by.selene.Entity.User
import com.asacsm.Dockerizing.a.Spring.Boot.by.selene.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(private val userRepository: UserRepository) {
    @GetMapping
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }
}