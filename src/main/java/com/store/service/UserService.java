package com.store.service;

import com.store.entity.User;

public interface UserService {
    public User findUserByEmail(String email);

    public void saveUser(User user);
}