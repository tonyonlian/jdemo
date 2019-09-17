package com.tongyl.example.jdemocoffee.repository;

import com.tongyl.example.jdemocoffee.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Created by Tunyl on 2019/9/10.
 * @version 1.0
 */
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder,Long> {
}
