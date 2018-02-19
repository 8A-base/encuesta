/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.controller;

import mx.edu.utez.encuesta.service.CandyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dvd
 */
@org.springframework.stereotype.Controller
@RequestMapping("encuesta")
public class ControllerMoncas {

    @GetMapping("/")
    public String dashboard() {
        return "restRouter";
    }

    /*
    @RequestMapping(value="showAll",method=RequestMethod.GET)
    @GetMapping("showAll")
    public String goCandy(Model model) {

        model.addAttribute("candies", candyService.findAllCandy());
        return "candies";
    }
    */
}
