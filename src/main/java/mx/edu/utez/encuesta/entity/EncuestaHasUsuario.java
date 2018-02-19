/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "encuesta_has_usuario")
@NamedQueries({
    @NamedQuery(name = "EncuestaHasUsuario.findAll", query = "SELECT e FROM EncuestaHasUsuario e")})
public class EncuestaHasUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EncuestaHasUsuarioPK encuestaHasUsuarioPK;
    @JoinColumn(name = "Encuesta_idEncuesta", referencedColumnName = "idEncuesta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Encuesta encuesta;
    @JoinColumn(name = "Respuesta_idRespuesta", referencedColumnName = "idRespuesta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Respuesta respuesta;
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public EncuestaHasUsuario() {
    }

    public EncuestaHasUsuario(EncuestaHasUsuarioPK encuestaHasUsuarioPK) {
        this.encuestaHasUsuarioPK = encuestaHasUsuarioPK;
    }

    public EncuestaHasUsuario(int encuestaidEncuesta, int usuarioidUsuario, int respuestaidRespuesta) {
        this.encuestaHasUsuarioPK = new EncuestaHasUsuarioPK(encuestaidEncuesta, usuarioidUsuario, respuestaidRespuesta);
    }

    public EncuestaHasUsuarioPK getEncuestaHasUsuarioPK() {
        return encuestaHasUsuarioPK;
    }

    public void setEncuestaHasUsuarioPK(EncuestaHasUsuarioPK encuestaHasUsuarioPK) {
        this.encuestaHasUsuarioPK = encuestaHasUsuarioPK;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (encuestaHasUsuarioPK != null ? encuestaHasUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EncuestaHasUsuario)) {
            return false;
        }
        EncuestaHasUsuario other = (EncuestaHasUsuario) object;
        if ((this.encuestaHasUsuarioPK == null && other.encuestaHasUsuarioPK != null) || (this.encuestaHasUsuarioPK != null && !this.encuestaHasUsuarioPK.equals(other.encuestaHasUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.utez.encuesta.entity.EncuestaHasUsuario[ encuestaHasUsuarioPK=" + encuestaHasUsuarioPK + " ]";
    }
    
}
