package com.facens.ac2.repository;

import com.facens.ac2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.facens.ac2.model.User;

public interface UserRepository extends JpaRepository<User, Long> {}
