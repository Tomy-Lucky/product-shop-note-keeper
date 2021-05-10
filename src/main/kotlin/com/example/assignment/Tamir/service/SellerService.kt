package com.example.assignment.Tamir.service

import com.example.assignment.Tamir.exception.ElementNotFoundException
import com.example.assignment.Tamir.model.SellerModel
import com.example.assignment.Tamir.model.toDTO
import com.example.assignment.Tamir.repository.SellerRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SellerService(
    private val sellerRepository: SellerRepository
) {

    @Transactional
    fun getAll() = sellerRepository.findAll().map { it.toDTO() }

    @Transactional
    fun getById(id: Long) =
        sellerRepository.findByIdOrNull(id)?.toDTO() ?: throw ElementNotFoundException("seller by id $id")

    @Transactional
    fun getByName(name: String) =
        sellerRepository.findByName(name)?.toDTO() ?: throw ElementNotFoundException("seller by name $name")

    @Transactional
    fun getByNameAndPassword(name: String, password: String) =
        sellerRepository.findByNameAndPassword(name = name, password = password)
            ?: throw ElementNotFoundException("seller by name $name, password $password")

    @Transactional
    fun create(name: String, password: String) = sellerRepository.save(
        SellerModel(
            id = 0,
            name = name,
            password = password,
            cash = 0,
            products = arrayListOf()
        )
    ).toDTO()
}
