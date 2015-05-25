package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Questions;
import model.Quizzes;
import model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-25T14:39:55")
@StaticMetamodel(Results.class)
public class Results_ { 

    public static volatile SingularAttribute<Results, Integer> id;
    public static volatile SingularAttribute<Results, Questions> questionsId;
    public static volatile SingularAttribute<Results, Boolean> answerD;
    public static volatile SingularAttribute<Results, User> userid;
    public static volatile SingularAttribute<Results, Boolean> answerB;
    public static volatile SingularAttribute<Results, Boolean> answerC;
    public static volatile SingularAttribute<Results, Quizzes> quizzesId;
    public static volatile SingularAttribute<Results, Boolean> answerA;

}