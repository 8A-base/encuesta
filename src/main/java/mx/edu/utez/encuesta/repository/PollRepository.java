/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.repository;

import java.util.List;
import mx.edu.utez.encuesta.entity.Poll;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alumno
 */
@Configuration
@Repository
public interface PollRepository extends JpaRepository<Poll, String> {

    Poll findPollById(String poll);

    List<Poll> findAll();
}
