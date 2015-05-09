/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.Questions;

/**
 *
 * @author ted
 */

@Path("/questions")
public class QuestionsFacadeREST extends AbstractFacade<Questions> {
    @PersistenceContext(unitName = "BackendDITprojPU")
    private EntityManager em = Persistence.createEntityManagerFactory("BackendDITprojPU").createEntityManager();

    public QuestionsFacadeREST() {
        super(Questions.class);
    }

    @POST
    @Consumes({"application/xml","application/json"})
    @Produces({"application/json"})
    public Questions create2(Questions entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }
    
    @POST
    @Path("/list")
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/json"})
    public List<Questions> createlist(List<Questions> entitylist) {
        for (int i = 0; i < entitylist.size(); i++){
        em.getTransaction().begin();
        em.persist(entitylist.get(i));
        em.getTransaction().commit();
        }
        return entitylist;
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Questions entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Questions find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Questions> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Questions> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
