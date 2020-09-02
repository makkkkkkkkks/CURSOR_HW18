package com.company.makkkkkkkks.service;

import com.company.makkkkkkkks.entity.User;
import com.company.makkkkkkkks.repository.BookRepository;
import com.company.makkkkkkkks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    /*@Autowired
    private BookRepository bookRepository;*/

    public User getUserById(Long id) {
        return userRepository.getUserById(1l);
    }

    public boolean addUser(String name) {
        User user = new User();
        user.setName(name);
        userRepository.createUser(user);
        return true;
    }

    public List<User> findAllUser() {
        return userRepository.showAllUsers();
    }

    public boolean updateUser(Long id, String name) {
        User user = userRepository.getUserById(id);
        user.setName(name);
        return userRepository.updateUser(user);
    }

    public void createUser(User user) {
        userRepository.createUser(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }
}
