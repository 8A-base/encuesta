/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dvd
 */
@org.springframework.stereotype.Controller
@RequestMapping("encuesta")
public class ControllerEncuesta {

    @GetMapping("/")
    public String dashboard() {
        return "restRouter";
    }

}
