package com.online.ltbook.controllers;


import com.online.ltbook.models.Book;
import com.online.ltbook.models.ResponseObject;
import com.online.ltbook.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Books")
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping("")
    List<Book> getAllBooks(){
       return repository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id){
        Optional<Book> foundBook = repository.findById(id);

        return foundBook.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("success", "query book successfully", foundBook)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("fail", "can't find book with id =" + id, "")
                );
    }

    @PostMapping("/GetByType")
    ResponseEntity<ResponseObject> fieldByType(@RequestBody Book book){
        List<Book> foundBook = repository.findByType(book.getType().trim());
        return foundBook.size() > 0 ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("success", "query book successfully", foundBook)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("fail", "can't find book follow type", "")
                );
    }

    @PostMapping("/create")
    ResponseEntity<ResponseObject> insertBook(@RequestBody Book newBook){

        List<Book> foundBook = repository.findByName(newBook.getName().trim());
        if(foundBook.size() > 0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("fail", "Book name already exist", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject("success", "create new book successfully", repository.save(newBook))
        );
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateBook(@RequestBody Book newBook, @PathVariable Long id){
        Book updatedBook = repository.findById(id).map(book -> {
            book.setName(newBook.getName());
            book.setPrice(newBook.getPrice());
            book.setRating(newBook.getRating());
            book.setDescription(newBook.getDescription());
            book.setArtistAvatar(newBook.getArtistAvatar());
            book.setArtistName(newBook.getArtistName());
            book.setArtistBornDay(newBook.getArtistBornDay());
            book.setType(newBook.getType());
            book.setStatus(newBook.getStatus());
            book.setCreateBy(newBook.getCreateBy());
            book.setCreateAt(newBook.getCreateAt());
            book.setUpdateBy(newBook.getUpdateBy());
            book.setUpdateAt(newBook.getUpdateAt());
            return repository.save(book);
        }).orElseGet(() -> {
            newBook.setId(id);
            return repository.save(newBook);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject("success", "update book successfully", updatedBook)
        );
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteBook(@PathVariable Long id){
        boolean existId = repository.existsById(id);
        if(existId){
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "delete book successfully", "")
            );
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("fail", "can't find book to delete", "")
            );
        }
    }
}
