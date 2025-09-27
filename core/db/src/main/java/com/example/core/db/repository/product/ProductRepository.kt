package com.example.core.db.repository.product

import com.example.core.db.entity.ProductEntity

interface ProductRepository {
    suspend fun insertProduct(product: ProductEntity)

    suspend fun getProducts(): List<ProductEntity>
}