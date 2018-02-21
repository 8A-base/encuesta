/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.controller;

import mx.edu.utez.encuesta.EncuestaApplication;
import mx.edu.utez.encuesta.entity.Answer;
import mx.edu.utez.encuesta.service.AnswerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alumno
 */
@RestController
@CrossOrigin
@RequestMapping("/api/answer")
public class ControllerAnswer {

    static Logger log = Logger.getLogger(EncuestaApplication.class.getName());

    @Autowired
    private AnswerService answerService;

    @GetMapping("/getAll")
    public List<Answer> getQuestion() {
        log.info("obteniendo todas las respuestas");
        return answerService.findAll();
    }

    @RequestMapping("/{id}")
    public Answer findById(@PathVariable("id") Integer idAnswer) {
        log.info("Returning respuesta with id: " + idAnswer);
        return answerService.findAnswerById(idAnswer);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer answer) {
        log.info("Borrando la respuesta: " + answer);
        answerService.delete(answer);
    }

    @RequestMapping(value = "/question/", method = RequestMethod.POST)
    public void create(@RequestBody Answer answer) {
        log.info("Guardando la pregunta: " + answer.toString());
        answerService.save(answer);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody Answer answer) {
        log.info("Actualizando pregunta: " + answer.toString());
        answerService.save(answer);
    }





}
