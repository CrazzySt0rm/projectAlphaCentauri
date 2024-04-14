package com.example.projectAlphaCentauri.controllers;


import com.example.projectAlphaCentauri.model.AlphaCentauri;
import com.example.projectAlphaCentauri.service.AlphaCentauriService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
//@Controller
public class AlphaCentauriController {

    public final AlphaCentauriService alphaCentauriService;

    public AlphaCentauriController(AlphaCentauriService alphaCentauriService) {
        this.alphaCentauriService = alphaCentauriService;
    }

    @GetMapping("/")
    public String makeAC(@RequestParam(name = "username", required = false) String username, Model model) {
        model.addAttribute("makeAC", alphaCentauriService.alphaCentauriList(username));
        return "home";
    }

    @GetMapping("/alphacentauri/{id}")
    public String alphaCentauriInfo(@PathVariable Long id, Model model) {
        AlphaCentauri alphaCentauri = alphaCentauriService.getAlphaCentauriById(id);
        model.addAttribute("alphacentauri", alphaCentauri);
        model.addAttribute("images", alphaCentauri.getImages());
        return "info";
    }


    @PostMapping("/alphacentauri/")
    public String postM(@RequestParam("file1") MultipartFile file1, AlphaCentauri alphaCentauri) throws IOException {
        alphaCentauriService.saveAlphaCentauri(alphaCentauri, file1);

        return "info";
    }
    @CrossOrigin
    @PostMapping("/login_form")
    public String sU(@RequestBody AlphaCentauri alphaCentauri) {
        System.out.printf("saving %s", alphaCentauri);
        return "login_form";
    }
}

