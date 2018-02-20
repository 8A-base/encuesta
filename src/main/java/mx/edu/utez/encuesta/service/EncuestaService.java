/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.service;

import java.util.List;
import mx.edu.utez.encuesta.entity.Encuesta;

/**
 *
 * @author Alumno
 */
public interface EncuestaService {

    void saveEncuesta(Encuesta encuesta);

    void deleteEncuesta(Encuesta encuesta);


    Encuesta findEncuestaById(Encuesta encuesta);

    List<Encuesta> findAll();
}
