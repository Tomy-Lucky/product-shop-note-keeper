package com.example.assignment.Tamir.repository

import com.example.assignment.Tamir.model.SellerModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SellerRepository : JpaRepository<SellerModel, Long> {

    fun findByName(name: String): SellerModel?

    fun findByNameAndPassword(name: String, password: String): SellerModel?
}
