package com.asacsm.Dockerizing.a.Spring.Boot.by.selene.repository

import com.asacsm.Dockerizing.a.Spring.Boot.by.selene.Entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>