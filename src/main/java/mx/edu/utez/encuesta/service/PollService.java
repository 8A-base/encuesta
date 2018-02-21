/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.service;

import java.util.List;
import mx.edu.utez.encuesta.entity.Poll;

/**
 *
 * @author Alumno
 */
public interface PollService {

    void save(Poll poll);

    void delete(String poll);

    Poll findPollById(String poll);

    List<Poll> findAll();
}
