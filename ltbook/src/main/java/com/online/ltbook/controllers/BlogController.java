package com.online.ltbook.controllers;


import com.online.ltbook.models.Blog;
import com.online.ltbook.models.ResponseObject;
import com.online.ltbook.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Blogs")
public class BlogController {

    @Autowired
    private BlogRepository repository;

    @GetMapping("")
    List<Blog> getAllBlog(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id){
        Optional<Blog> foundBlog = repository.findById(id);

        return foundBlog.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("success", "query blog successfully", foundBlog)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("fail", "can't find blog with id =" + id, "")
                );
    }

    @PostMapping("/create")
    ResponseEntity<ResponseObject> insertBlog(@RequestBody Blog newBlog){

        List<Blog> foundBlog = repository.findByTitle(newBlog.getTitle().trim());
        if(foundBlog.size() > 0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("fail", "Blog name already exist", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "create new blog successfully", repository.save(newBlog))
        );
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateBlog(@RequestBody Blog newBlog, @PathVariable Long id){
        Blog updatedBlog = repository.findById(id).map(blog -> {
            blog.setTitle(newBlog.getTitle());
            blog.setContent(newBlog.getContent());
            blog.setTags(newBlog.getTags());
            blog.setStatus(newBlog.getStatus());
            blog.setCreateBy(newBlog.getCreateBy());
            blog.setCreateAt(newBlog.getCreateAt());
            blog.setUpdateBy(newBlog.getUpdateBy());
            blog.setUpdateAt(newBlog.getUpdateAt());
            return repository.save(blog);
        }).orElseGet(() -> {
            newBlog.setId(id);
            return repository.save(newBlog);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "update blog successfully", updatedBlog)
        );
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteBlog(@PathVariable Long id){
        boolean existId = repository.existsById(id);
        if(existId){
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "delete blog successfully", "")
            );
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("fail", "can't find blog to delete", "")
            );
        }
    }
}
