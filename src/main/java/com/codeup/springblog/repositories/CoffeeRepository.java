package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Coffee;
import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    Coffee findById(long id);
}
