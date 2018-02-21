/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.service.impl;

import mx.edu.utez.encuesta.entity.Answer;
import mx.edu.utez.encuesta.repository.AnswerRepository;
import mx.edu.utez.encuesta.service.AnswerService;
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
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    @Override
    public void save(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public void delete(Integer answer) {
        answerRepository.delete(answer);
    }

    @Override
    public Answer findAnswerById(Integer answer) {
        return answerRepository.findAnswerById(answer);
    }

    @Override
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

}
