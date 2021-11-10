package com.online.ltbook.controllers;

import com.online.ltbook.models.Cart;
import com.online.ltbook.models.ResponseObject;
import com.online.ltbook.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Carts")
public class CartController {

    @Autowired
    private CartRepository repository;

    @GetMapping("")
    List<Cart> getAllCarts(){
        return repository.findAll();
    }

    @PostMapping("/create")
    ResponseEntity<ResponseObject> insertCart(@RequestBody Cart newCart){

        List<Cart> foundCart = repository.findByCode(newCart.getCode().trim());
        if(foundCart.size() > 0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("fail", "Cart name already exist", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "create new cart successfully", repository.save(newCart))
        );
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateCart(@RequestBody Cart newCart, @PathVariable Long id){
        Cart updatedCart = repository.findById(id).map(cart -> {
            cart.setIdUser(newCart.getIdUser());
            cart.setAccessToken(newCart.getAccessToken());
            cart.setCode(newCart.getCode());
            cart.setAmount(newCart.getAmount());
            cart.setTotal(newCart.getTotal());
            cart.setStatus(newCart.getStatus());
            cart.setNameCustomer(newCart.getNameCustomer());
            cart.setPhoneCustomer(newCart.getPhoneCustomer());
            cart.setAddressCustomer(newCart.getAddressCustomer());
            return repository.save(cart);
        }).orElseGet(() -> {
            newCart.setId(id);
            return repository.save(newCart);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "update cart successfully", updatedCart)
        );
    }
}
