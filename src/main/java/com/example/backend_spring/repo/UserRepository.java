package com.example.backend_spring.repo;

import com.example.backend_spring.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    void deleteByUsername(String username);

    @Modifying
    @Query("update User u set u.phoneNumber = :phoneNumber where u.username = :username")
    void setPhoneNumberUser(@Param(value = "phoneNumber") String phoneNumber,
            @Param(value = "username") String username);
}
