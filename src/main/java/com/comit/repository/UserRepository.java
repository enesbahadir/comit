package com.comit.repository;

import com.comit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin(origins = "http://localhost:4200")
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value ="SELECT u FROM User u WHERE u.username = ?1")
    User findByUsername(String username);
}
