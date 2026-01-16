package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
    // Find user by email (custom query method)
    Optional<User> findByEmail(String email);
    
    // Find users by first name (case insensitive)
    List<User> findByFirstNameIgnoreCase(String firstName);
    
    // Find users by last name (case insensitive)
    List<User> findByLastNameIgnoreCase(String lastName);
    
    // Find users by age range
    List<User> findByAgeBetween(Integer minAge, Integer maxAge);
    
    // Find users by age greater than
    List<User> findByAgeGreaterThan(Integer age);
    
    // Find users by first name and last name
    List<User> findByFirstNameAndLastName(String firstName, String lastName);
    
    // Custom query to find users by email domain
    @Query("{'email': {$regex: ?0, $options: 'i'}}")
    List<User> findByEmailDomain(String domain);
    
    // Check if user exists by email
    boolean existsByEmail(String email);
    
    // Count users by age
    long countByAge(Integer age);
    
    // Delete user by email
    void deleteByEmail(String email);
}
