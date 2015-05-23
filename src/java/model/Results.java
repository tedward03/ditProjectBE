/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ted
 */
@Entity
@Table(name = "results")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Results.findAll", query = "SELECT r FROM Results r"),
    @NamedQuery(name = "Results.findByQuiz", query = "SELECT r FROM Results r WHERE r.quizzesId.id = ?1"),
    @NamedQuery(name = "Results.findByQuizAndUser", query = "SELECT r FROM Results r WHERE r.quizzesId.id = ?1 AND r.userid.id = ?2"),
    @NamedQuery(name = "Results.findById", query = "SELECT r FROM Results r WHERE r.id = :id"),
    @NamedQuery(name = "Results.countAnswerA", query = "SELECT Count(r) FROM Results r WHERE r.quizzesId.id = ?1 AND r.questionsId.id = ?2 AND r.answerA = 1"),
    @NamedQuery(name = "Results.countAnswerB", query = "SELECT Count(r) FROM Results r WHERE r.quizzesId.id = ?1 AND r.questionsId.id = ?2 AND r.answerB = 1"),
    @NamedQuery(name = "Results.countAnswerC", query = "SELECT Count(r) FROM Results r WHERE r.quizzesId.id = ?1 AND r.questionsId.id = ?2 AND r.answerC = 1"),
    @NamedQuery(name = "Results.countAnswerD", query = "SELECT Count(r) FROM Results r WHERE r.quizzesId.id = ?1 AND r.questionsId.id = ?2 AND r.answerD = 1")})
public class Results implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    /*
    @Column(name = "status")
    private String status;
    */

     @Column(name = "AnswerA")
    private Boolean answerA;

    @Column(name = "AnswerB")
    private Boolean answerB;

    @Column(name = "AnswerC")
    private Boolean answerC;

    @Column(name = "AnswerD")
    private Boolean answerD;

    @JoinColumn(name = "User_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userid;
    @JoinColumn(name = "questions_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Questions questionsId;
    @JoinColumn(name = "quizzes_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Quizzes quizzesId;

    public Results() {
    }

    public Results(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

/*
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
*/
    public Boolean getAnswerA() {
        return answerA;
    }

    public void setAnswerA(Boolean answerA) {
        this.answerA = answerA;
    }

    public Boolean getAnswerB() {
        return answerB;
    }

    public void setAnswerB(Boolean answerB) {
        this.answerB = answerB;
    }

    public Boolean getAnswerC() {
        return answerC;
    }

    public void setAnswerC(Boolean answerC) {
        this.answerC = answerC;
    }

    public Boolean getAnswerD() {
        return answerD;
    }

    public void setAnswerD(Boolean answerD) {
        this.answerD = answerD;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public Questions getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(Questions questionsId) {
        this.questionsId = questionsId;
    }

    public Quizzes getQuizzesId() {
        return quizzesId;
    }

    public void setQuizzesId(Quizzes quizzesId) {
        this.quizzesId = quizzesId;
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
        if (!(object instanceof Results)) {
            return false;
        }
        Results other = (Results) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Results[ id=" + id + " ]";
    }
    
}
