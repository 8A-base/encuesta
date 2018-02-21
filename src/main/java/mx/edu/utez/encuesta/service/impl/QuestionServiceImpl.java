/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.service.impl;

import mx.edu.utez.encuesta.entity.Question;
import mx.edu.utez.encuesta.repository.QuestionRepository;
import mx.edu.utez.encuesta.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author Alumno
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void delete(Integer question) {
        questionRepository.delete(question);
    }

    @Override
    public Question findQuestionById(Integer question) {
        return questionRepository.findQuestionById(question);
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

}
