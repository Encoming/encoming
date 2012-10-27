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
        throw new UnsupportedOperationException("Not supported yet.");
    }    
    
    @Override
    public Invoice find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
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
