/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author Alumno
 */
@Controller
@RequestMapping("encuesta")
public class EncuestaController {

    @GetMapping("/")
    public String dashboard() {
        return "restRouter";
    }

}
