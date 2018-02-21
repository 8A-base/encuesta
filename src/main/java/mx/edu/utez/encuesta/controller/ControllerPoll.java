/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.controller;

import mx.edu.utez.encuesta.EncuestaApplication;
import mx.edu.utez.encuesta.entity.Poll;
import mx.edu.utez.encuesta.service.PollService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alumno
 */
@RestController
@CrossOrigin
@RequestMapping("/api/poll")
public class ControllerPoll {

    static Logger log = Logger.getLogger(EncuestaApplication.class.getName());

    @Autowired
    private PollService pollService;

    @GetMapping("/getAll")
    public List<Poll> getPoll() {
        log.info("obteniendo todas las preguntas");
        return pollService.findAll();
    }

    @RequestMapping("/{id}")
    public Poll findById(@PathVariable("id") String idPoll) {
        log.info("Returning encuesta with id: " + idPoll);
        return pollService.findPollById(idPoll);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String poll) {
        log.info("Borrando la encuesta: " + poll);
        pollService.delete(poll);
    }

    @RequestMapping(value = "/poll/", method = RequestMethod.POST)
    public void create(@RequestBody Poll poll) {
        log.info("Guardando la encuesta: " + poll.toString());
        pollService.save(poll);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody Poll poll) {
        log.info("Actualizando encuesta: " + poll.toString());
        pollService.save(poll);
    }





}
