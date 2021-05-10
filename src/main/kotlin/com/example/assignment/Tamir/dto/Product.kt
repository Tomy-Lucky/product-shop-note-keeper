package com.example.assignment.Tamir.dto

import com.example.assignment.Tamir.model.ProductCategory

data class Product(
    val id: Long,
    val name: String,
    val cost: Int,
    val category: ProductCategory,
    var description: String,
    var clientIdList: List<Long>,
    var sellerId: Long
)
