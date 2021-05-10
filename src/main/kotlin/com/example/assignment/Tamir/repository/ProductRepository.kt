package com.example.assignment.Tamir.repository

import com.example.assignment.Tamir.model.ProductModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<ProductModel, Long> {

    fun findByName(name: String): ProductModel?
}
