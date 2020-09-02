package com.company.makkkkkkkks.entity;

import lombok.Data;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, List<Books> bookList) {
        this.name = name;
        this.bookList = bookList;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private List<Books> bookList;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
