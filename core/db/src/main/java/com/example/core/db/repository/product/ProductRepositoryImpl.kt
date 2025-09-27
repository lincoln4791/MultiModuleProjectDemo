package com.example.core.db.repository.product

import com.example.core.db.AppDatabase
import com.example.core.db.entity.ProductEntity
import com.example.core.db.entity.UserEntity

class ProductRepositoryImpl(private val db: AppDatabase) : ProductRepository {

    override suspend fun insertProduct(product: ProductEntity) {
        db.productDao().insert(product)
    }

    override suspend fun getProducts(): List<ProductEntity> {
        return db.productDao().getAllProducts()
    }
}