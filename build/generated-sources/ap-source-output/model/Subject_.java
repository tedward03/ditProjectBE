package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Quizzes;
import model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-09T17:42:13")
@StaticMetamodel(Subject.class)
public class Subject_ { 

    public static volatile SingularAttribute<Subject, Integer> id;
    public static volatile SingularAttribute<Subject, String> title;
    public static volatile CollectionAttribute<Subject, Quizzes> quizzesCollection;
    public static volatile CollectionAttribute<Subject, User> userCollection;

}