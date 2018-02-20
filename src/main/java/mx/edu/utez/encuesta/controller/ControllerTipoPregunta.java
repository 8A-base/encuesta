/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.controller;

import mx.edu.utez.encuesta.EncuestaApplication;
import mx.edu.utez.encuesta.entity.Pregunta;
import mx.edu.utez.encuesta.service.PreguntaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alumno
 */
@RestController
@CrossOrigin
@RequestMapping("/api/tipoPregunta")
public class ControllerTipoPregunta {

    static Logger log = Logger.getLogger(EncuestaApplication.class.getName());

    @Autowired
    private PreguntaService preguntaService;

    @GetMapping("/getAll")
    public List<Pregunta> getPregunta() {
        log.info("obteniendo todas las preguntas");
        return preguntaService.findAllPregunta();
    }
    
}
