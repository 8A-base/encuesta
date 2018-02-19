/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.controller;

import mx.edu.utez.encuesta.MoncasApplication;
import mx.edu.utez.encuesta.entity.Candy;
import mx.edu.utez.encuesta.service.CandyService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alumno
 */
@RestController
@CrossOrigin
@RequestMapping("/api/candy")
public class ControllerCandy {

    static Logger log = Logger.getLogger(MoncasApplication.class.getName());

    @Autowired
    private CandyService candyService;

    @GetMapping("/getAll")
    public List<Candy> getCandy() {
        log.info("Retrieving all candies");
        return candyService.findAllCandy();
    }

    @RequestMapping("/{id}")
    public Candy findById(@PathVariable("id") Integer idCandy) {
        log.info("Returning candy with id: " + idCandy);
        return candyService.findById(idCandy);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer idCandy) {
        log.info("Deleting candy with id: " + idCandy);
        candyService.delete(idCandy);
    }

    @RequestMapping(value = "/candy/", method = RequestMethod.POST)
    public void createCandy(@RequestBody Candy candy) {
        log.info("Saving candy: " + candy.toString());
        candyService.saveCandy(candy);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void updateCandy(@RequestBody Candy candy) {
        log.info("Updating candy: " + candy.toString());
        candyService.saveCandy(candy);
    }
    
    
    
    
    
}
