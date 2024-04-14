package com.example.projectAlphaCentauri.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "reg_form")
@Data
public class Registration {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "confirmation_code")
    private long confirmation_code;
    @Column(name = "password")
    private String password;
    @Column(name = "password_repeat")
    private String password_repeat;
    @Column(name = "confirm_terms") // тут будет кнопка принять пользовательское соглашение
    private String confirm_terms;
}
