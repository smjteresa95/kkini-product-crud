package com.kkini.kkiniadminbackend.repository.product;

import com.kkini.kkiniadminbackend.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
