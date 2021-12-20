package com.example.backend_spring.services;

import java.util.List;

import com.example.backend_spring.models.Role;
import com.example.backend_spring.models.User;

public interface UserService{

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    void removeOne(String username);

    void updatePhoneNumberUser(String phoneNumber, String username);

    List<User> getUsers();
}
