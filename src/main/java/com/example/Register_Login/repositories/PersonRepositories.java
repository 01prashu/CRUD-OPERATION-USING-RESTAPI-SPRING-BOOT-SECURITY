package com.example.Register_Login.repositories;

import com.example.Register_Login.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepositories extends JpaRepository<Person, Integer> {
     @Query("SELECT u FROM Person u WHERE u.email = ?1")
     Optional<Person> findByEmail(String email);
}
