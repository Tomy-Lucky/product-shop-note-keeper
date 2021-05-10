package com.example.assignment.Tamir.repository

import com.example.assignment.Tamir.model.ClientModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository : JpaRepository<ClientModel, Long> {

    fun findByName(name: String): ClientModel?

    fun findByNameAndPassword(name: String, password: String): ClientModel?
}
