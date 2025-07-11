package com.query.MultipleParameters.repositories;


import com.query.MultipleParameters.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    // Method 1: Using Method Name Query (Spring Data JPA automatically generates query)
    Optional<User> findByUsernameAndEmail(String username, String email);

    // Method 2: Using Multiple Parameters with 'And'
    List<User> findByRoleAndEmail(String role, String email);

    // Method 3: Custom JPQL Query
    //@Query("SELECT u FROM User u WHERE u.username = ?1 AND u.role = ?2")
    List<User> findByUsernameAndRole(String username, String role);

    // Method 4: Native SQL Query
    @Query(value = "SELECT * FROM user WHERE email = :email AND role = :role", nativeQuery = true)
    List<User> findByEmailAndRoleNative(String email, String role);
}
