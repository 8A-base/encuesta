/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.service;

import mx.edu.utez.encuesta.entity.Pregunta;

import java.util.List;

/**
 * @author dvd
 */
public interface TipoPreguntaService {
    List<Pregunta> findAllTipoPregunta();

    Pregunta findById(Integer idPregunta);

}
