/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.service;

import mx.edu.utez.encuesta.entity.Question;

import java.util.List;

/**
 *
 * @author Alumno
 */
public interface QuestionService {

    void save(Question question);

    void delete(Integer question);

    Question findQuestionById(Integer question);

    List<Question> findAll();
}
