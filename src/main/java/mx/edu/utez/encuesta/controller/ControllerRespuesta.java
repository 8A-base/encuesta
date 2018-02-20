/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.controller;

import java.util.List;
import mx.edu.utez.encuesta.EncuestaApplication;
import mx.edu.utez.encuesta.entity.Pregunta;
import mx.edu.utez.encuesta.entity.Respuesta;
import mx.edu.utez.encuesta.service.RespuestaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author GABY
 */
@RestController
@CrossOrigin
@RequestMapping("/api/respuesta")
public class ControllerRespuesta {
    static Logger log = Logger.getLogger(EncuestaApplication.class.getName());

    @Autowired
    private RespuestaService respuestaService;

    @GetMapping("/getAll")
    public List<Respuesta> getRespuesta() {
        log.info("obteniendo todas las respuestas");
        return respuestaService.findAllRespuesta();
    }

    @RequestMapping("/{id}")
    public Respuesta findById(@PathVariable("id") Integer idRespuesta) {
        log.info("Returning respuesta with id: " + idRespuesta);
        return respuestaService.findById(idRespuesta);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer idRespuesta) {
        log.info("Borrando la respuesta: " + idRespuesta);
        respuestaService.delete(idRespuesta);
    }

    @RequestMapping(value = "/respuesta/", method = RequestMethod.POST)
    public void createCandy(@RequestBody Respuesta respuesta) {
        log.info("Guardando la respuesta: " + respuesta.toString());
        respuestaService.saveRespuesta(respuesta);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void updateCandy(@RequestBody Respuesta respuesta) {
        log.info("Actualizando respuesta: " + respuesta.toString());
        respuestaService.saveRespuesta(respuesta);
    }
    
    
}
