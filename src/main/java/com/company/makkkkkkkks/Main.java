package com.company.makkkkkkkks;

import com.company.makkkkkkkks.config.Config;
import com.company.makkkkkkkks.entity.Books;
import com.company.makkkkkkkks.entity.User;
import com.company.makkkkkkkks.menu.Menu;
import com.company.makkkkkkkks.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(Config.class);

        Menu menu = annotationConfigApplicationContext.getBean(Menu.class);
        menu.menu();
        UserService userService = annotationConfigApplicationContext.getBean(UserService.class);
        userService.createUser(new User("Arnold", List.of(new Books("Test"))));
        System.out.println(userService.getUserById(2l));
    }
}
