package com.germanovich.cryptocurrencywatcher.repository;

import com.germanovich.cryptocurrencywatcher.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}