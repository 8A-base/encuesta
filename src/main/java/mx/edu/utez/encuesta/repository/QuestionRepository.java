/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.repository;

import mx.edu.utez.encuesta.entity.Question;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Alumno
 */
@Configuration
@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    Question findQuestionById(Integer question);

    List<Question> findAll();
}
