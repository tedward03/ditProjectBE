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
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.Results;

/**
 *
 * @author ted
 */

@Path("/results")
public class ResultsFacadeREST extends AbstractFacade<Results> {
    @PersistenceContext(unitName = "BackendDITprojPU")
    private EntityManager em = Persistence.createEntityManagerFactory("BackendDITprojPU").createEntityManager();

    public ResultsFacadeREST() {
        super(Results.class);
    }
/* post one result into a table*/
    @POST
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/json"})
    public Results create2(Results entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }
/* post a series of results*/
    @POST
    @Path("/list")
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/json"})
    public List<Results> createlist(List<Results> entitylist) {
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
    public void edit(@PathParam("id") Integer id, Results entity) {
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
    public Results find(@PathParam("id") Integer id) {
        return super.find(id);
    }
/* get results and filter by quiz id */
    @GET
    @Path("/quiz/{id}")
    @Produces({"application/json"})
    public List<Results> findbyquiz(@PathParam("id") Integer id) {
        Query query = em.createNamedQuery("Results.findByQuiz");
        query.setParameter(1, id);
        return query.getResultList();
    }
    
    @GET
    @Path("/quiz/{id}/stu/{user}")
    @Produces({"application/json"})
    public List<Results> findbyquizanduser(@PathParam("id") Integer id, @PathParam("user") Integer user) {
        Query query = em.createNamedQuery("Results.findByQuizAndUser");
        query.setParameter(1, id);
        query.setParameter(2, user);
        return query.getResultList();
    }
    @GET
    @Path("/qq/{id}/Count/")
    @Produces({"application/json"})
    public Object resultcount(@PathParam("id") Integer id) {
        Query query;
        String concat="{ \"result\":\"[";
        
        for(int quest=1;quest <13;quest++){
        
        query = em.createNamedQuery("Results.countAnswerA");
        query.setParameter(1, id);
        query.setParameter(2, quest);
        concat= concat+"[" + query.getSingleResult().toString() + ",";
        query = em.createNamedQuery("Results.countAnswerB");
        query.setParameter(1, id);
        query.setParameter(2, quest);
        concat = concat + query.getSingleResult().toString()+ ",";
        query = em.createNamedQuery("Results.countAnswerC");
        query.setParameter(1, id);
        query.setParameter(2, quest);
        concat = concat + query.getSingleResult().toString() + ",";
        query = em.createNamedQuery("Results.countAnswerD");
        query.setParameter(1, id);
        query.setParameter(2, quest);
        concat = concat + query.getSingleResult().toString() + "]";
        if (quest <12){
            concat = concat +",";
        }
        else{
            concat = concat +"]\"}";
            }
        }
        /*
        String concat = "{";
        query = em.createNamedQuery("Results.countAnswerA");
        query.setParameter(1, id);
        query.setParameter(2, quest);
        concat = concat +"\"AnswerA\":"+ query.getSingleResult().toString()+",";
        
        query = em.createNamedQuery("Results.countAnswerB");
        query.setParameter(1, id);
        query.setParameter(2, quest);
        concat = concat +"\"AnswerB\":"+ query.getSingleResult().toString()+",";
        
        query = em.createNamedQuery("Results.countAnswerC");
        query.setParameter(1, id);
        query.setParameter(2, quest);
        concat = concat +"\"AnswerC\":"+ query.getSingleResult().toString()+",";
        
        query = em.createNamedQuery("Results.countAnswerD");
        query.setParameter(1, id);
        query.setParameter(2, quest);
        concat = concat +"\"AnswerD\":"+ query.getSingleResult().toString()+"}";
        */
        return concat;
    }
    
    
    
    
    @GET
    @Override
    @Produces({"application/json"})
    public List<Results> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Results> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
