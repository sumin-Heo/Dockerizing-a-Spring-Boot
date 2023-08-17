package com.asacsm.Dockerizing.a.Spring.Boot.by.selene.Entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    val username: String,
    val password: String
)