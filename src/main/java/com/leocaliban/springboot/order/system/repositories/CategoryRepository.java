package com.leocaliban.springboot.order.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leocaliban.springboot.order.system.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
