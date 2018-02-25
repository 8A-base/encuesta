/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.controller;

import mx.edu.utez.encuesta.entity.User;
import mx.edu.utez.encuesta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * @author Alumno
 */
@Controller
@RequestMapping("encuesta")
public class EncuestaController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String dashboard(Model model) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(loggedInUser.getName());
        model.addAttribute("user", user);
        return "restRouter";
    }

}
