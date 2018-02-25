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
public class PollUserPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "poll_id")
    private int pollId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "answer_id")
    private int answerId;
    @Column(name = "open")
    private String open;

    public PollUserPK() {
    }

    public PollUserPK(int pollId, int userId, int answerId, String open) {
        this.pollId = pollId;
        this.userId = userId;
        this.answerId = answerId;
        this.open = open;
    }

    public int getPollId() {
        return pollId;
    }

    public void setPollId(int pollId) {
        this.pollId = pollId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pollId;
        hash += (int) userId;
        hash += (int) answerId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PollUserPK)) {
            return false;
        }
        PollUserPK other = (PollUserPK) object;
        if (this.pollId != other.pollId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        if (this.answerId != other.answerId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.utez.encuesta.entity.PollUserPK[ pollId=" + pollId + ", userId=" + userId + ", answerId=" + answerId + " ]";
    }
    
}
