package com.example.assignment.Tamir.controller

import com.example.assignment.Tamir.service.ClientService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("client")
class ClientController(
    private val clientService: ClientService
) {

    @GetMapping("/find-all")
    fun getAll() = clientService.getAll()

    @GetMapping("/find-by-name")
    fun getByName(@RequestParam("name") name: String) = clientService.getByName(name)

    @GetMapping("/find-by-id")
    fun getById(@RequestParam("id") id: Long) = clientService.getById(id)

    @PostMapping("/create-account")
    fun createClient(@RequestBody createClient: CreateClient) = clientService.create(
        name = createClient.name,
        password = createClient.password
    )

    @GetMapping("/buy-product")
    fun buyProduct(
        @RequestParam("id") id: Long,
        @RequestParam("productId") productId: Long
    ) = clientService.buyProduct(id = id, productId = productId)
}

data class CreateClient(
    val name: String,
    val password: String
)
