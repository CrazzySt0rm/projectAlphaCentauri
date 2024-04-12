package com.example.projectAlphaCentauri.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alphacentauri")
public class AlphaCentauri {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "username")
    private String username;  //логин
    @Column(name = "password")
    private String password;  //пароль

}
