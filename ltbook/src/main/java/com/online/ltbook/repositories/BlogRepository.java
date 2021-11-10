package com.online.ltbook.repositories;

import com.online.ltbook.models.Blog;
import com.online.ltbook.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByTitle (String title);
}
