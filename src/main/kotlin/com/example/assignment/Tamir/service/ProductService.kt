package com.example.assignment.Tamir.service

import com.example.assignment.Tamir.dto.Product
import com.example.assignment.Tamir.exception.ElementNotFoundException
import com.example.assignment.Tamir.model.ProductCategory
import com.example.assignment.Tamir.model.ProductModel
import com.example.assignment.Tamir.model.toDTO
import com.example.assignment.Tamir.repository.ProductRepository
import com.example.assignment.Tamir.repository.SellerRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val sellerRepository: SellerRepository
) {

    @Transactional
    fun getAll() = productRepository.findAll().map { it.toDTO() }

    @Transactional
    fun getById(id: Long) =
        productRepository.findByIdOrNull(id)?.toDTO() ?: throw ElementNotFoundException("product with id: $id")

    @Transactional
    fun deleteById(id: Long) {
        productRepository.deleteById(id)
    }

    @Transactional
    fun getByName(name: String) =
        productRepository.findByName(name)?.toDTO() ?: throw ElementNotFoundException("product with name: $name")

    @Transactional
    fun create(name: String, description: String, cost: Int, category: ProductCategory, sellerId: Long): Product {
        val seller = sellerRepository.findByIdOrNull(sellerId)
            ?: throw ElementNotFoundException("seller with id: $sellerId")

        return productRepository.save(
            ProductModel(
                id = 0,
                name = name,
                description = description,
                category = category,
                cost = cost,
                seller = seller,
                clients = arrayListOf()
            )
        ).toDTO()
    }
}
