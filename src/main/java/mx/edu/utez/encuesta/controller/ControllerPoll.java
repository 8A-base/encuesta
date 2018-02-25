/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.controller;

import mx.edu.utez.encuesta.EncuestaApplication;
import mx.edu.utez.encuesta.entity.Poll;
import mx.edu.utez.encuesta.entity.User;
import mx.edu.utez.encuesta.repository.UserRepository;
import mx.edu.utez.encuesta.service.PollService;
import mx.edu.utez.encuesta.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

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

    @Autowired
    private UserService userService;

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
    public String create(@RequestBody Poll poll) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(loggedInUser.getName());
        poll.setUserId(user);
        poll.setId(getSaltString());
        poll.setDate(new Date());
        poll.setIspublic((short)0);
        pollService.save(poll);
        return poll.getId();
    }

    @RequestMapping(value = "/update/", method = RequestMethod.PATCH)
    public void update(@RequestBody Poll poll) {
        log.info("Actualizando encuesta: " + poll.toString());
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(loggedInUser.getName());
        poll.setUserId(user);
        pollService.save(poll);
    }

    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        while (salt.length() < 6) {
            int index = (int) (new Random().nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }


}
