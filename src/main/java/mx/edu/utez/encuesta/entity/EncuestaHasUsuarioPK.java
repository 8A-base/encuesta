/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Usuario
 */
@Embeddable
public class EncuestaHasUsuarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Encuesta_idEncuesta")
    private String encuestaidEncuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Usuario_idUsuario")
    private int usuarioidUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Respuesta_idRespuesta")
    private int respuestaidRespuesta;

    public EncuestaHasUsuarioPK() {
    }

    public EncuestaHasUsuarioPK(String encuestaidEncuesta, int usuarioidUsuario, int respuestaidRespuesta) {
        this.encuestaidEncuesta = encuestaidEncuesta;
        this.usuarioidUsuario = usuarioidUsuario;
        this.respuestaidRespuesta = respuestaidRespuesta;
    }

    public String getEncuestaidEncuesta() {
        return encuestaidEncuesta;
    }

    public void setEncuestaidEncuesta(String encuestaidEncuesta) {
        this.encuestaidEncuesta = encuestaidEncuesta;
    }

    public int getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(int usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public int getRespuestaidRespuesta() {
        return respuestaidRespuesta;
    }

    public void setRespuestaidRespuesta(int respuestaidRespuesta) {
        this.respuestaidRespuesta = respuestaidRespuesta;
    }


    @Override
    public String toString() {
        return "mx.edu.utez.encuesta.entity.EncuestaHasUsuarioPK[ encuestaidEncuesta=" + encuestaidEncuesta + ", usuarioidUsuario=" + usuarioidUsuario + ", respuestaidRespuesta=" + respuestaidRespuesta + " ]";
    }
    
}
