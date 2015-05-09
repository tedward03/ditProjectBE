/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author ted
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(model.service.QuestionsFacadeREST.class);
        resources.add(model.service.QuizzesFacadeREST.class);
        resources.add(model.service.ResultsFacadeREST.class);
        resources.add(model.service.SubjectFacadeREST.class);
        resources.add(model.service.UserFacadeREST.class);
    }
    
}
