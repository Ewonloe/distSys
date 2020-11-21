package com.example.repositories;

import com.example.models.User;

import java.util.List;

public interface UserRepo {

    public List<User> getAllUser();
    public String createUser(User user);
    public User getUser(Integer id);
    public String updateUser(User user);
    public String deleteUser(User user);
}
