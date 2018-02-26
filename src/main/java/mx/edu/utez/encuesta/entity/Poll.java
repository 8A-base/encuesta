/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.entity;

import com.fasterxml.jackson.annotation.*;
import mx.edu.utez.encuesta.controller.ControllerPoll;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "poll")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poll.findAll", query = "SELECT p FROM Poll p")
    , @NamedQuery(name = "Poll.findById", query = "SELECT p FROM Poll p WHERE p.id = :id")
    , @NamedQuery(name = "Poll.findByName", query = "SELECT p FROM Poll p WHERE p.name = :name")
    , @NamedQuery(name = "Poll.findByDescription", query = "SELECT p FROM Poll p WHERE p.description = :description")
    , @NamedQuery(name = "Poll.findByDate", query = "SELECT p FROM Poll p WHERE p.date = :date")})
public class Poll implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @NotNull
    @Column(name = "ispublic")
    private Short ispublic;
    @ManyToMany(mappedBy = "pollList")
    private List<Question> questionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poll")
    private List<PollUser> pollUserList;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public Poll() {
    }

    public Poll(String id) {
        this.id = id;
    }

    public Poll(String id, String name, Date date, Short ispublic) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.ispublic = ispublic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Short getIspublic() {
        return ispublic;
    }

    public void setIspublic(short ispublic) {
        this.ispublic = ispublic;
    }

    @XmlTransient
    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    @XmlTransient
    public List<PollUser> getPollUserList() {
        return pollUserList;
    }

    public void setPollUserList(List<PollUser> pollUserList) {
        this.pollUserList = pollUserList;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poll)) {
            return false;
        }
        Poll other = (Poll) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.utez.encuesta.entity.Poll[ id=" + id + " ]";
    }
    
}
