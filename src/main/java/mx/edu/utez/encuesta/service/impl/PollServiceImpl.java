/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.service.impl;

import java.util.List;
import mx.edu.utez.encuesta.entity.Poll;
import mx.edu.utez.encuesta.repository.PollRepository;
import mx.edu.utez.encuesta.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alumno
 */
@Service
@Transactional
public class PollServiceImpl implements PollService {

    @Autowired
    PollRepository pollRepository;

    @Override
    public void save(Poll poll) {
        pollRepository.save(poll);
    }

    @Override
    public void delete(String poll) {
        pollRepository.delete(poll);
    }

    @Override
    public Poll findPollById(String poll) {
        return pollRepository.findPollById(poll);
    }

    @Override
    public List<Poll> findAll() {
        return pollRepository.findAll();
    }

}
