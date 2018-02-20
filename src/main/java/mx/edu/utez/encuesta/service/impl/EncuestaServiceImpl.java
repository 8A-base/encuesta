/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.service.impl;

import java.util.List;
import mx.edu.utez.encuesta.entity.Encuesta;
import mx.edu.utez.encuesta.repository.EncuestaRepository;
import mx.edu.utez.encuesta.service.EncuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alumno
 */
@Service
@Transactional
public class EncuestaServiceImpl implements EncuestaService {

    @Autowired
    EncuestaRepository encuestaRepository;

    @Override
    public void saveEncuesta(Encuesta encuesta) {
        encuestaRepository.save(encuesta);
    }

    @Override
    public void deleteEncuesta(Encuesta encuesta) {
        encuestaRepository.delete(encuesta);
    }

    @Override
    public Encuesta findEncuestaById(Encuesta encuesta) {
        return encuestaRepository.findEncuestaById(encuesta);
    }

    @Override
    public List<Encuesta> findAll() {
        return encuestaRepository.findAll();
    }

}
