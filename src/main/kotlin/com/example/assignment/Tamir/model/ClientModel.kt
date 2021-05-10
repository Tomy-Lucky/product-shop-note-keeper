package com.example.assignment.Tamir.model

import com.example.assignment.Tamir.dto.Client
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "client")
class ClientModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,

    @Column
    var name: String,

    @Column
    var password: String,

    @Column
    var cash: Int,

    @ManyToMany
    var purchasedProducts: MutableList<ProductModel>
)

fun ClientModel.toDTO() = Client(
    id = id,
    name = name,
    password = password,
    cash = cash,
    purchasedProducts = purchasedProducts.map { it.toDTO() }
)

