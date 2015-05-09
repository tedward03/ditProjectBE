package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Quizzes;
import model.Results;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-09T17:42:13")
@StaticMetamodel(Questions.class)
public class Questions_ { 

    public static volatile SingularAttribute<Questions, Integer> id;
    public static volatile CollectionAttribute<Questions, Results> resultsCollection;
    public static volatile SingularAttribute<Questions, String> actAnswer;
    public static volatile SingularAttribute<Questions, String> answerD;
    public static volatile SingularAttribute<Questions, String> answerB;
    public static volatile SingularAttribute<Questions, String> question;
    public static volatile SingularAttribute<Questions, String> answerC;
    public static volatile SingularAttribute<Questions, Quizzes> quizzesId;
    public static volatile SingularAttribute<Questions, String> answerA;

}