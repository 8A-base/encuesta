/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.service.impl;

import mx.edu.utez.encuesta.entity.Pregunta;
import mx.edu.utez.encuesta.repository.PreguntaRepository;
import mx.edu.utez.encuesta.service.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author dvd
 */
@Service
@Transactional
public class PreguntaServiceImpl implements PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Override
    public List<Pregunta> findAllCandy() {
        return preguntaRepository.findAll();
    }

    @Override
    public Pregunta findById(Integer idPregunta) {
        return preguntaRepository.findById(idPregunta);
    }

    @Override
    public Pregunta saveCandy(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @Override
    public Integer delete(Integer idPregunta) {
        preguntaRepository.delete(idPregunta);
        return idPregunta;
    }
}
