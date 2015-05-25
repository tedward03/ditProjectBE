package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Quizzes;
import model.Results;
import model.Subject;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-25T14:39:55")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, String> lname;
    public static volatile CollectionAttribute<User, Results> resultsCollection;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, Date> updateTime;
    public static volatile SingularAttribute<User, String> userrole;
    public static volatile CollectionAttribute<User, Quizzes> quizzesCollection;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> fname;
    public static volatile CollectionAttribute<User, Subject> subjectCollection;

}