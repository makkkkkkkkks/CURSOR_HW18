package com.company.makkkkkkkks.menu;

import com.company.makkkkkkkks.entity.Books;
import com.company.makkkkkkkks.entity.User;
import com.company.makkkkkkkks.service.BookService;
import com.company.makkkkkkkks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    private Scanner sc;//= new Scanner(System.in);
    private final String command =
            "1. Add user" + "\n" +
                    "2. Delete user" + "\n" +
                    "3. Update user" + "\n" +
                    "4. Find user by id" + "\n" +
                    "5. Find all user" + "\n" +
                    "6. Find all books by id" + "\n" +
                    "7. Add book to user" + "\n" +
                    "0. Exit";

    @Autowired
    public Menu(UserService userService, BookService bookService) {
        this.bookService = bookService;
        this.userService = userService;
        sc = new Scanner(System.in);
    }

    public void menu() {
        while (true) {
            System.out.println(command);
            switch (sc.next()) {
                case "1" -> addUser();
                case "2" -> deleteUserByid();
                case "3" -> updateUser();
                case "4" -> findUserById();
                case "5" -> findAllUsers();
                case "6" -> findAllUserBooks();
                case "7" -> addBookToUser();
                case "0" -> System.exit(0);
            }
        }
    }

    private void addUser() {
        System.out.println("enter user name ->");
        userService.addUser(sc.next());
    }

    private void deleteUserByid() {
        System.out.println("User id ->  ");
        userService.deleteUser(sc.nextLong());
    }

    private User findUserById() {
        System.out.println("User id ->  ");
        return userService.getUserById(sc.nextLong());
    }

    private void updateUser() {
        System.out.println("User id ->  ");
        Long id = sc.nextLong();
        System.out.println("New user name ->  ");
        String name = sc.next();
        System.out.println(name);
        System.out.println(id + "___" + name);
    }

    private void findAllUsers() {
        userService.findAllUser().forEach(u -> System.out.println(u));
    }

    private void addBookToUser() {
        System.out.println("User id ->  ");
        Long id = sc.nextLong();
        System.out.println("enter book name ->");
        String name = sc.next();
        userService.addBookToUser(id, name);
    }

    private void deleteBookByid() {
        System.out.println("User id ->  ");
        bookService.deleteBook(sc.nextLong());
    }

    private Books findBookById() {
        System.out.println("User id ->  ");
        return bookService.getBookById(sc.nextLong());
    }

    private void findAllUserBooks() {
        System.out.println("Owner id ->  ");
        Long id = sc.nextLong();
        userService.findeAllBooks(id).forEach(System.out::println);
    }

}
