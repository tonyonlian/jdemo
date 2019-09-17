package com.tongyl.example.jdemocoffee.repository;

import com.tongyl.example.jdemocoffee.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Created by Tunyl on 2019/9/10.
 * @version 1.0
 */
public interface CoffeeRepository extends JpaRepository<Coffee,Long> {
}
