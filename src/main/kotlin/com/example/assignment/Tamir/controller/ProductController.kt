package com.example.assignment.Tamir.controller

import com.example.assignment.Tamir.model.ProductCategory
import com.example.assignment.Tamir.service.ProductService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:4200"], maxAge = 3600)
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

    @DeleteMapping("/delete-by-id")
    fun deleteById(@RequestParam("id") id: Long) = productService.deleteById(id)

    @GetMapping("create-product")
    fun createProduct(
        @RequestParam("name") name: String,
        @RequestParam("description") description: String,
        @RequestParam("category") category: ProductCategory,
        @RequestParam("cost") cost: Int,
        @RequestParam("sellerId") sellerId: Long
    ) = productService.create(
        name = name,
        description = description,
        category = category,
        cost = cost,
        sellerId = sellerId
    )

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
