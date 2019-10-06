package com.leocaliban.springboot.order.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leocaliban.springboot.order.system.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
