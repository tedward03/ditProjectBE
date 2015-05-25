package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Questions;
import model.Results;
import model.Subject;
import model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-25T14:39:55")
@StaticMetamodel(Quizzes.class)
public class Quizzes_ { 

    public static volatile SingularAttribute<Quizzes, Integer> id;
    public static volatile SingularAttribute<Quizzes, String> title;
    public static volatile CollectionAttribute<Quizzes, Results> resultsCollection;
    public static volatile SingularAttribute<Quizzes, Subject> subjectId;
    public static volatile SingularAttribute<Quizzes, User> creatorId;
    public static volatile CollectionAttribute<Quizzes, Questions> questionsCollection;

}