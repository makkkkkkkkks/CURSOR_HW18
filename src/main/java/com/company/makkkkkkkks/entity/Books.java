package com.company.makkkkkkkks.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;

    public Books(String name) {
        this.name = name;
    }

    public Books() {
    }
}
