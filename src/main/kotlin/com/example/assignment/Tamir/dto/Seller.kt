package com.example.assignment.Tamir.dto

data class Seller(
    val id: Long,
    val name: String,
    val password: String,
    val cash: Int,
    val products: List<Product>
)
