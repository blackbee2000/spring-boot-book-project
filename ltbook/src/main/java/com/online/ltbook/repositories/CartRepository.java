package com.online.ltbook.repositories;

import com.online.ltbook.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByCode (String code);
}
