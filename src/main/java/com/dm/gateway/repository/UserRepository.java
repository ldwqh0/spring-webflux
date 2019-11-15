package com.dm.gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dm.gateway.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
