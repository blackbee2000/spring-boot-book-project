package com.online.ltbook.controllers;

import com.online.ltbook.models.Blog;
import com.online.ltbook.models.ProductCart;
import com.online.ltbook.models.ResponseObject;
import com.online.ltbook.repositories.ProductCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/ProductCarts")
public class ProductController {

    @Autowired
    private ProductCartRepository repository;

    @GetMapping("")
    List<ProductCart> getAllProductCart(){
        return repository.findAll();
    }

    @PostMapping("/create")
    ResponseEntity<ResponseObject> insertProductCart(@RequestBody ProductCart newProductCart){

        List<ProductCart> foundProductCard = repository.findByName(newProductCart.getName().trim());
        if(foundProductCard.size() > 0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("fail", "Product Cart name already exist", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "create new product cart successfully", repository.save(newProductCart))
        );
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateProductCart(@RequestBody ProductCart newProductCart, @PathVariable Long id){
        ProductCart updatedProductCart = repository.findById(id).map(productCart -> {
            productCart.setIdCard(newProductCart.getIdCard());
            productCart.setAmount(newProductCart.getAmount());
            productCart.setPrice(newProductCart.getPrice());
            productCart.setTotal(newProductCart.getTotal());
            productCart.setName(newProductCart.getName());
            productCart.setRating(newProductCart.getRating());
            productCart.setImgUrl(newProductCart.getImgUrl());
            return repository.save(productCart);
        }).orElseGet(() -> {
            newProductCart.setId(id);
            return repository.save(newProductCart);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "update product cart successfully", updatedProductCart)
        );
    }
}
