package com.online.ltbook.repositories;

import com.online.ltbook.models.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCartRepository extends JpaRepository<ProductCart, Long> {
    List<ProductCart> findByName (String name);
}
