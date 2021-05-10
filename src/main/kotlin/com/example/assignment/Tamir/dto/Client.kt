package com.example.assignment.Tamir.dto

data class Client(
    val id: Long,
    val name: String,
    val password: String,
    val cash: Int,
    val purchasedProducts: List<Product>
)
