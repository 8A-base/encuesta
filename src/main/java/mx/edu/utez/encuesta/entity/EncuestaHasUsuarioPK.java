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
    private int encuestaidEncuesta;
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

    public EncuestaHasUsuarioPK(int encuestaidEncuesta, int usuarioidUsuario, int respuestaidRespuesta) {
        this.encuestaidEncuesta = encuestaidEncuesta;
        this.usuarioidUsuario = usuarioidUsuario;
        this.respuestaidRespuesta = respuestaidRespuesta;
    }

    public int getEncuestaidEncuesta() {
        return encuestaidEncuesta;
    }

    public void setEncuestaidEncuesta(int encuestaidEncuesta) {
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
    public int hashCode() {
        int hash = 0;
        hash += (int) encuestaidEncuesta;
        hash += (int) usuarioidUsuario;
        hash += (int) respuestaidRespuesta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EncuestaHasUsuarioPK)) {
            return false;
        }
        EncuestaHasUsuarioPK other = (EncuestaHasUsuarioPK) object;
        if (this.encuestaidEncuesta != other.encuestaidEncuesta) {
            return false;
        }
        if (this.usuarioidUsuario != other.usuarioidUsuario) {
            return false;
        }
        if (this.respuestaidRespuesta != other.respuestaidRespuesta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.utez.encuesta.entity.EncuestaHasUsuarioPK[ encuestaidEncuesta=" + encuestaidEncuesta + ", usuarioidUsuario=" + usuarioidUsuario + ", respuestaidRespuesta=" + respuestaidRespuesta + " ]";
    }
    
}
