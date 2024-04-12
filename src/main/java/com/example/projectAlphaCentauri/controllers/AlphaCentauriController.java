package com.example.projectAlphaCentauri.controllers;

import ch.qos.logback.core.model.Model;
import com.example.projectAlphaCentauri.service.AlphaCentauriService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlphaCentauriController {

    public final AlphaCentauriService alphaCentauriService;

    public AlphaCentauriController(AlphaCentauriService alphaCentauriService) {
        this.alphaCentauriService = alphaCentauriService;
    }

    @GetMapping("/")
    public String makeAC(@RequestParam ("alphacentauri") String username, Model model) {
        model.addText("makeAC");
        return "home";

    }
    @PostMapping("/reg_form")
    public String postM(@RequestParam("password") Model model) {
        model.hashCode();
        return "/redirect";
    }
}
