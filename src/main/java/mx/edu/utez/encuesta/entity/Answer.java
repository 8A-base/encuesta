/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "answer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Answer.findAll", query = "SELECT a FROM Answer a")
    , @NamedQuery(name = "Answer.findById", query = "SELECT a FROM Answer a WHERE a.id = :id")
    , @NamedQuery(name = "Answer.findByAnswer", query = "SELECT a FROM Answer a WHERE a.answer = :answer")})
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "answer")
    private String answer;
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("answerList")
    private Question questionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "answer")
    private List<PollUser> pollUserList;

    public Answer() {
    }

    public Answer(Integer id) {
        this.id = id;
    }

    public Answer(Integer id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    public Answer(Integer id, String answer, Question questionId) {
        this.id = id;
        this.answer = answer;
        this.questionId = questionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
    }

    @XmlTransient
    public List<PollUser> getPollUserList() {
        return pollUserList;
    }

    public void setPollUserList(List<PollUser> pollUserList) {
        this.pollUserList = pollUserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "mx.edu.utez.encuesta.entity.Answer[ id=" + id + " ]";
    }
    
}
