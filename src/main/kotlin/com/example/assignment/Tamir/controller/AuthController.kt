package com.example.assignment.Tamir.controller

import com.example.assignment.Tamir.service.AuthService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService
) {

    @GetMapping("/as-seller")
    fun authAsSeller(
        @RequestParam("userName", required = true) userName: String,
        @RequestParam("password", required = true) password: String
    ) = authService.authAsSellerByUserNameAndPassword(
        userName = userName,
        password = password
    )

    @GetMapping("/as-client")
    fun authAsClient(
        @RequestParam("userName", required = true) userName: String,
        @RequestParam("password", required = true) password: String
    ) = authService.authAsClientByUserNameAndPassword(
        userName = userName,
        password = password
    )
}
