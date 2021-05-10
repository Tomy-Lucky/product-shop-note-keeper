package com.example.assignment.Tamir.model

import com.example.assignment.Tamir.dto.Product
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "product")
class ProductModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,

    @Column
    var name: String,

    @Column
    var cost: Int,

    @Column
    var category: ProductCategory,

    @Column
    var description: String,

    @ManyToOne
    @JoinColumn("seller_id")
    var seller: SellerModel,

    @ManyToMany
    var clients: MutableList<ClientModel>
) : Serializable

enum class ProductCategory {
    FOOD,
    ELECTRONICS,
    LIGHT,
    SOLAR_ENERGY,
    CARS,
    PERSONAL_CARE
}

fun ProductModel.toDTO() = Product(
    id = id,
    name = name,
    cost = cost,
    category = category,
    description = description,
    sellerId = seller.id,
    clientIdList = clients.map { it.id }
)


