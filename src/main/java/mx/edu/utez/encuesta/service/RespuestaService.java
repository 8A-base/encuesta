/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.service;
import mx.edu.utez.encuesta.entity.Respuesta;
import java.util.List;

/**
 *
 * @author GABY
 */
public interface RespuestaService {
    List<Respuesta> findAllRespuesta();

    Respuesta findById(Integer idRespuesta);

    Respuesta saveRespuesta(Respuesta respuesta);

    Integer delete(Integer idRespuesta);
    
}
