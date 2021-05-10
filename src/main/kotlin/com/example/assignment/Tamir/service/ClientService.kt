package com.example.assignment.Tamir.service

import com.example.assignment.Tamir.dto.Client
import com.example.assignment.Tamir.exception.ElementNotFoundException
import com.example.assignment.Tamir.exception.ExpensiveCostException
import com.example.assignment.Tamir.model.ClientModel
import com.example.assignment.Tamir.model.toDTO
import com.example.assignment.Tamir.repository.ClientRepository
import com.example.assignment.Tamir.repository.ProductRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ClientService(
    private val clientRepository: ClientRepository,
    private val productRepository: ProductRepository
) {

    @Transactional
    fun getAll() = clientRepository.findAll().map { it.toDTO() }

    @Transactional
    fun getById(id: Long) =
        clientRepository.findByIdOrNull(id)?.toDTO() ?: throw ElementNotFoundException("client with id: $id")

    @Transactional
    fun getByName(name: String) =
        clientRepository.findByName(name = name)?.toDTO()
            ?: throw ElementNotFoundException("client with name $name")

    @Transactional
    fun getByNameAndPassword(name: String, password: String) =
        clientRepository.findByNameAndPassword(name = name, password = password)?.toDTO()
            ?: throw ElementNotFoundException("client with name $name and password $password")

    @Transactional
    fun create(name: String, password: String) = clientRepository.save(
        ClientModel(
            id = 0,
            name = name,
            password = password,
            cash = 0,
            purchasedProducts = arrayListOf()
        )
    ).toDTO()

    @Transactional
    fun refill(name: String, password: String, cash: Int): Client {
        val client = clientRepository.findByNameAndPassword(name = name, password = password)
            ?: throw ElementNotFoundException("client with name $name and password $password")

        client.cash += cash

        return client.toDTO()
    }

    @Transactional
    fun buyProduct(id: Long, productId: Long): Client {
        val client = clientRepository.findByIdOrNull(id) ?: throw ElementNotFoundException("client with id: $id")
        val product = productRepository.findByIdOrNull(id) ?: throw ElementNotFoundException("product with id: $id")

        if (product.cost > client.cash) throw ExpensiveCostException(
            clientId = id,
            clientCash = client.cash,
            productCost = product.cost
        )

        client.cash -= product.cost
        client.purchasedProducts.add(product)

        return client.toDTO()
    }
}
