package com.asacsm.Dockerizing.a.Spring.Boot.by.selene.controller

import com.asacsm.Dockerizing.a.Spring.Boot.by.selene.Entity.User
import com.asacsm.Dockerizing.a.Spring.Boot.by.selene.repository.UserRepository
import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/api/users")
class UserController(private val userRepository: UserRepository) {
    @GetMapping
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<User> {
        val user = userRepository.findById(id)
        return if (user.isPresent) {
            ResponseEntity.ok(user.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }


    @PostMapping
    fun createUser(@RequestBody newUser: User): ResponseEntity<User> {
        val createdUser = userRepository.save(newUser)
        val location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(createdUser.id)
            .toUri()
        return ResponseEntity.created(location).body(createdUser)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody updatedUser: User): ResponseEntity<User> {
        val existingUser = userRepository.findById(id)
        return if (existingUser.isPresent) {
            updatedUser.id = id
            userRepository.save(updatedUser)
            ResponseEntity.ok(updatedUser)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Unit> {
        val existingUser = userRepository.findById(id)
        return if (existingUser.isPresent) {
            userRepository.deleteById(id)
            ResponseEntity.ok().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
