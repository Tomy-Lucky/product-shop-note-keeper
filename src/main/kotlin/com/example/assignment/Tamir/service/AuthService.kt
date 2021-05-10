package com.example.assignment.Tamir.service

import com.example.assignment.Tamir.web.jwt.JWTService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthService(
    private val jwtService: JWTService,
    private val sellerService: SellerService,
    private val clientService: ClientService
) {

    @Transactional
    fun authAsSellerByUserNameAndPassword(userName: String, password: String): String {
        val seller = sellerService.getByNameAndPassword(name = userName, password = password)
        return jwtService.sign(accountId = seller.id)
    }

    @Transactional
    fun authAsClientByUserNameAndPassword(userName: String, password: String): String {
        val client = clientService.getByNameAndPassword(name = userName, password = password)
        return jwtService.sign(accountId = client.id)
    }
}
