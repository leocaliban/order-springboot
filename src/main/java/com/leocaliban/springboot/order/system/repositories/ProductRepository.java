package com.leocaliban.springboot.order.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leocaliban.springboot.order.system.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
