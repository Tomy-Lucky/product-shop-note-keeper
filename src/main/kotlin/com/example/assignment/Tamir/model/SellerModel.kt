package com.example.assignment.Tamir.model

import com.example.assignment.Tamir.dto.Seller
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "seller")
class SellerModel(
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

    @OneToMany(mapped = "seller")
    var products: MutableList<ProductModel>
)

fun SellerModel.toDTO() = Seller(
    id = id,
    name = name,
    password = password,
    cash = cash,
    products = products.map { it.toDTO() }
)
