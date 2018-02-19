/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.repository;

import mx.edu.utez.encuesta.entity.Pregunta;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author dvd
 */
@Configuration
@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {
    Pregunta findById(Integer idPregunta);
}
