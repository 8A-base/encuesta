/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.service.impl;

import mx.edu.utez.encuesta.entity.PollUser;
import mx.edu.utez.encuesta.repository.PollUserRepository;
import mx.edu.utez.encuesta.service.PollUserService;
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
public class PollUserServiceImpl implements PollUserService {

    @Autowired
    PollUserRepository pollUserRepository;

    @Override
    public void save(PollUser opinion) {
        pollUserRepository.save(opinion);
    }
}
