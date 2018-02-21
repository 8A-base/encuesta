/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.controller;

import mx.edu.utez.encuesta.EncuestaApplication;
import mx.edu.utez.encuesta.entity.Question;
import mx.edu.utez.encuesta.service.QuestionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alumno
 */
@RestController
@CrossOrigin
@RequestMapping("/api/question")
public class ControllerQuestion {

    static Logger log = Logger.getLogger(EncuestaApplication.class.getName());

    @Autowired
    private QuestionService questionService;

    @GetMapping("/getAll")
    public List<Question> getQuestion() {
        log.info("obteniendo todas las preguntas");
        return questionService.findAll();
    }

    @RequestMapping("/{id}")
    public Question findById(@PathVariable("id") Integer idQuestion) {
        log.info("Returning pregunta with id: " + idQuestion);
        return questionService.findQuestionById(idQuestion);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer question) {
        log.info("Borrando la pregunta: " + question);
        questionService.delete(question);
    }

    @RequestMapping(value = "/question/", method = RequestMethod.POST)
    public void create(@RequestBody Question question) {
        log.info("Guardando la pregunta: " + question.toString());
        questionService.save(question);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody Question question) {
        log.info("Actualizando pregunta: " + question.toString());
        questionService.save(question);
    }





}
