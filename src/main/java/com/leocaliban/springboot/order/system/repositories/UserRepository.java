package com.leocaliban.springboot.order.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leocaliban.springboot.order.system.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
