package com.example.assignment.Tamir.controller

import com.example.assignment.Tamir.service.SellerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/seller")
class SellerController(
    private val sellerService: SellerService
) {

    @GetMapping("/find-all")
    fun getAll() = sellerService.getAll()

    @GetMapping("/find-by-name")
    fun getByName(@RequestParam("name") name: String) = sellerService.getByName(name)

    @GetMapping("/find-by-id")
    fun getById(@RequestParam("id") id: Long) = sellerService.getById(id)

    @PostMapping("/create-account")
    fun CreateSeller(@RequestBody createSeller: CreateSeller) =
        sellerService.create(name = createSeller.name, password = createSeller.password)
}

data class CreateSeller(
    val name: String,
    val password: String
)

