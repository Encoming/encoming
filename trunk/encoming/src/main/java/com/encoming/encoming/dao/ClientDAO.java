/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.dao;

import com.encoming.encoming.entity.Client;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Tutas
 */
public class ClientDAO implements IDAO<Client>{
    
    private static ClientDAO instance;
    
    public static synchronized ClientDAO getInstance() {
        if (instance == null) {
            instance = new ClientDAO();
        }
        return instance;
    }
    
    @Override
    public void persist(Client entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }    
    
    @Override
    public Client find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void update(Client entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public List<Client> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
