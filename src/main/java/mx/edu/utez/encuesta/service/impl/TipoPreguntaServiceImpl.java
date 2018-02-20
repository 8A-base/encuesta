/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.service.impl;

import mx.edu.utez.encuesta.entity.Tipopregunta;
import mx.edu.utez.encuesta.repository.TipoPreguntaRepository;
import mx.edu.utez.encuesta.service.TipoPreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author dvd
 */
@Service
@Transactional
public class TipoPreguntaServiceImpl implements TipoPreguntaService {

    @Autowired
    private TipoPreguntaRepository tipoPreguntaRepository;

    @Override
    public List<Tipopregunta> findAllTipoPregunta() {
        return tipoPreguntaRepository.findAll();
    }
}
