/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.entity;

import com.fasterxml.jackson.annotation.*;
import mx.edu.utez.encuesta.controller.ControllerQuestion;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "question")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q")
    , @NamedQuery(name = "Question.findById", query = "SELECT q FROM Question q WHERE q.id = :id")
    , @NamedQuery(name = "Question.findByQuestion", query = "SELECT q FROM Question q WHERE q.question = :question")})
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "question")
    private String question;
    @JoinTable(name = "poll_question", joinColumns = {
            @JoinColumn(name = "question_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "poll_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Poll> pollList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionId")
    private List<Answer> answerList;
    @JoinColumn(name = "id_type", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Type idType;

    public Question() {
    }

    public Question(Integer id) {
        this.id = id;
    }

    public Question(Integer id, String question) {
        this.id = id;
        this.question = question;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @JsonIgnoreProperties(value = {"questionList"}, allowSetters = true)
    @XmlTransient
    public List<Poll> getPollList() {
        return pollList;
    }

    public void setPollList(List<Poll> pollList) {
        this.pollList = pollList;
    }

    @XmlTransient
    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public Type getIdType() {
        return idType;
    }

    public void setIdType(Type idType) {
        this.idType = idType;
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
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.utez.encuesta.entity.Question[ id=" + id + " ]";
    }
    
}
