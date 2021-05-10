package com.example.assignment.Tamir.controller

import com.example.assignment.Tamir.model.ProductCategory
import com.example.assignment.Tamir.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("product")
class ProductController(
    private val productService: ProductService
) {

    @GetMapping("/find-all")
    fun getAll() = productService.getAll()

    @GetMapping("/find-by-name")
    fun getByName(@RequestParam("name") name: String) = productService.getByName(name)

    @GetMapping("/find-by-id")
    fun getById(@RequestParam("id") id: Long) = productService.getById(id)

    @PostMapping("create-product")
    fun createProduct(@RequestBody createProduct: CreateProduct) = productService.create(
        name = createProduct.name,
        description = createProduct.description,
        category = createProduct.category,
        cost = createProduct.cost,
        sellerId = createProduct.sellerId
    )
}

data class CreateProduct(
    val name: String,
    val description: String,
    val cost: Int,
    val category: ProductCategory,
    val sellerId: Long
)
