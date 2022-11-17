package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {



}
