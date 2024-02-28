package com.clone.instagram.repository;

import org.springframework.stereotype.Repository;

import com.clone.instagram.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer>{

    UserEntity findByUserName(String userName);

    UserEntity findByEmail(String email);
}
