/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "poll_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PollUser.findAll", query = "SELECT p FROM PollUser p")
    , @NamedQuery(name = "PollUser.findByPollId", query = "SELECT p FROM PollUser p WHERE p.pollUserPK.pollId = :pollId")
    , @NamedQuery(name = "PollUser.findByUserId", query = "SELECT p FROM PollUser p WHERE p.pollUserPK.userId = :userId")
    , @NamedQuery(name = "PollUser.findByAnswerId", query = "SELECT p FROM PollUser p WHERE p.pollUserPK.answerId = :answerId")})
public class PollUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PollUserPK pollUserPK;
    @JoinColumn(name = "poll_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Poll poll;
    @JoinColumn(name = "answer_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Answer answer;
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public PollUser() {
    }

    public PollUser(PollUserPK pollUserPK) {
        this.pollUserPK = pollUserPK;
    }

    public PollUser(String pollId, int userId, int answerId) {
        this.pollUserPK = new PollUserPK(pollId, userId, answerId);
    }

    public PollUserPK getPollUserPK() {
        return pollUserPK;
    }

    public void setPollUserPK(PollUserPK pollUserPK) {
        this.pollUserPK = pollUserPK;
    }

    @JsonIgnore
    @JsonProperty(value = "pollUserList")
    @XmlTransient
    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    @JsonIgnore
    @JsonProperty(value = "pollUserList")
    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @JsonIgnore
    @JsonProperty(value = "pollUserList")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pollUserPK != null ? pollUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PollUser)) {
            return false;
        }
        PollUser other = (PollUser) object;
        if ((this.pollUserPK == null && other.pollUserPK != null) || (this.pollUserPK != null && !this.pollUserPK.equals(other.pollUserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.utez.encuesta.entity.PollUser[ pollUserPK=" + pollUserPK + " ]";
    }

}
