package com.store.serviceImpl;

import com.store.entity.Role;
import com.store.entity.User;
import com.store.repository.ClothesRepostirory;
import com.store.repository.RoleRepository;
import com.store.repository.ShoesRepository;
import com.store.repository.UserRepository;
import com.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ClothesRepostirory clothesRepository;

    private final ShoesRepository shoesRepository;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder,
                           ClothesRepostirory clothesRepository1,
                           ShoesRepository shoesRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.clothesRepository = clothesRepository1;

        this.shoesRepository = shoesRepository;
    }



    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

}