package com.example.projectAlphaCentauri.controllers;

import com.example.projectAlphaCentauri.models.AlphaCentauri;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
@RestController
public class AlphaCentauriController {

    @GetMapping("/")
    public String GetAC() {
        return "Hello from home";

    }
    @CrossOrigin
    @PostMapping("/login_form")
    public String sU(@RequestBody AlphaCentauri alphaCentauri) {
        System.out.printf("saving %s", alphaCentauri);
        return "login_form";
    }
}

