package com.spring.security.repository;

import com.spring.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    List<User> findByFirstNameContaining(String name);

    List<User> findAll();

    @Query(value = "SELECT * FROM User WHERE FirstName LIKE %:firstName%  AND LastName Like %:lastName%", nativeQuery = true)
    List<User> findByName(String firstName, String lastName);

    Optional<User> findByEmail(String email);
    @Query(value = "SELECT password FROM user WHERE email = ?1", nativeQuery = true)
    String getPassword(String email);

    Optional<User> findById(Long id);

    void deleteById(Long id);
}
