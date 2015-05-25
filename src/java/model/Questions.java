/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ted
 */
@Entity
@Table(name = "questions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questions.findAll", query = "SELECT q FROM Questions q"),
    @NamedQuery(name = "Questions.findbyquiz", query = "SELECT q FROM Questions q WHERE q.quizzesId.id = ?1"),
    @NamedQuery(name = "Questions.findById", query = "SELECT q FROM Questions q WHERE q.id = :id"),
    @NamedQuery(name = "Questions.findByAnswerA", query = "SELECT q FROM Questions q WHERE q.answerA = :answerA"),
    @NamedQuery(name = "Questions.findByAnswerB", query = "SELECT q FROM Questions q WHERE q.answerB = :answerB"),
    @NamedQuery(name = "Questions.findByAnswerC", query = "SELECT q FROM Questions q WHERE q.answerC = :answerC"),
    @NamedQuery(name = "Questions.findByAnswerD", query = "SELECT q FROM Questions q WHERE q.answerD = :answerD"),
    @NamedQuery(name = "Questions.findByActAnswer", query = "SELECT q FROM Questions q WHERE q.actAnswer = :actAnswer")})
public class Questions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "Question")
    private String question;
    @Column(name = "AnswerA")
    private String answerA;
    @Column(name = "AnswerB")
    private String answerB;
    @Column(name = "AnswerC")
    private String answerC;
    @Column(name = "AnswerD")
    private String answerD;
    @Column(name = "ActAnswer")
    private String actAnswer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionsId")
    private Collection<Results> resultsCollection;
    @JoinColumn(name = "quizzes_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Quizzes quizzesId;

    public Questions() {
    }

    public Questions(Integer id) {
        this.id = id;
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

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getActAnswer() {
        return actAnswer;
    }

    public void setActAnswer(String actAnswer) {
        this.actAnswer = actAnswer;
    }

    @XmlTransient
    public Collection<Results> getResultsCollection() {
        return resultsCollection;
    }

    public void setResultsCollection(Collection<Results> resultsCollection) {
        this.resultsCollection = resultsCollection;
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
        if (!(object instanceof Questions)) {
            return false;
        }
        Questions other = (Questions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Questions[ id=" + id + " ]";
    }
    
}
