/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.dao;

import com.encoming.encoming.entity.Invoice;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Tutas
 */
public class InvoiceDAO implements IDAO<Invoice>{
    
    private static InvoiceDAO instance;
    
    public static synchronized InvoiceDAO getInstance() {
        if (instance == null) {
            instance = new InvoiceDAO();
        }
        return instance;
    }
    
    @Override
    public void persist(Invoice entity, EntityManager em) {
        try {
            em.persist(entity);
        } catch (Exception e) {
        }
    }    
    
    @Override
    public Invoice find(Object idA, EntityManager em) {
        Integer id = (Integer) idA;
        javax.persistence.Query query = em.createQuery("SELECT i FROM Invoice i "
                + "WHERE i.idInvoice =:idInvoice")
                .setParameter("idInvoice", id);
        return (Invoice) query.getSingleResult();
    }
    
    @Override
    public void update(Invoice entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public List<Invoice> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
