/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import mx.edu.utez.encuesta.entity.Respuesta;

import mx.edu.utez.encuesta.repository.RespuestaRepository;
import mx.edu.utez.encuesta.service.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author GABY
 */
@Service
@Transactional
public class RespuestaServiceImpl implements RespuestaService{
    @Autowired
    private RespuestaRepository respuestaRepository;

    @Override
    public List<Respuesta> findAllRespuesta() {
        return respuestaRepository.findAll();

    @Override
    public Respuesta findById(Integer idRespuesta) {
        return respuestaRepository.findById(idRespuesta);
    }

    @Override
    public Respuesta savePregunta(Respuesta respuesta) {
       return respuestaRepository.save(respuesta);
    }

    @Override
    public Integer delete(Integer idRespuesta) {
        respuestaRepository.delete(idRespuesta);
        return idRespuesta;
    }
       
    
    
}
