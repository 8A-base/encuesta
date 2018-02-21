/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.service;

import mx.edu.utez.encuesta.entity.Answer;

import java.util.List;

/**
 *
 * @author Alumno
 */
public interface AnswerService {

    void save(Answer answer);

    void delete(Integer answer);

    Answer findAnswerById(Integer answer);

    List<Answer> findAll();
}
