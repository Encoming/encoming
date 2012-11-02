/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.dao;

import com.encoming.encoming.entity.Driver;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Andrezz
 */
public class DriverDAO implements IDAO<Driver> {
    
    private static DriverDAO instance;
    
    public static synchronized DriverDAO getInstance() {
        if (instance == null) {
            instance = new DriverDAO();
        }
        return instance;
    }
    
    @Override
    public void persist(Driver entity, EntityManager em) {
        em.persist(entity);
    }    
    
    @Override
    public Driver find(Object id, EntityManager em) {
        Query query = em.createQuery("SELECT dri FROM Driver dri "
                + "WHERE dri.personidPerson.idPerson =:idPerson")
                .setParameter("idPerson", id);
        return (Driver)query.getSingleResult();
    }
    
    @Override
    public void update(Driver entity, EntityManager em) {
        em.merge(em);
    }
    
    @Override
    public void delete(Object id, EntityManager em) {
         Driver dri = find(id, em);
        em.remove(dri);
    }
    
    @Override
    public List<Driver> getList(EntityManager em) {
        Query query = em.createNamedQuery("Driver.findAll");
        List<Driver> lista = query.getResultList();
        return lista;
    }   
}
