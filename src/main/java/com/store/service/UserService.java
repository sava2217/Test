package com.store.service;

import com.store.entity.User;

public interface UserService {

    User findUserByEmail(String email);

    void saveUser(User user);
}