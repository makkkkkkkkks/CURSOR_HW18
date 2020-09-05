package com.company.makkkkkkkks.service;

import com.company.makkkkkkkks.entity.Books;
import com.company.makkkkkkkks.entity.User;
import com.company.makkkkkkkks.repository.BookRepository;
import com.company.makkkkkkkks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    public boolean addUser(String name) {
        User user = new User();
        user.setName(name);
        userRepository.createUser(user);
        return true;
    }

    public void addBookToUser(Long id, String bookName) {
        User user = getUserById(id);
        System.out.println(user);
        Books bookAdd = new Books();
        bookAdd.setName(bookName);
        bookAdd.setOwner(user);
        bookRepository.createBooks(bookAdd);
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

    public List<Books> findeAllBooks(Long id) {
        return getUserById(id).getBookList();
    }
}
