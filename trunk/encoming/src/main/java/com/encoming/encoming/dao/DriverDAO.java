/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.dao;

import com.encoming.encoming.entity.Driver;
import java.util.List;
import javax.persistence.EntityManager;

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
        throw new UnsupportedOperationException("Not supported yet.");
    }    
    
    @Override
    public Driver find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void update(Driver entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public List<Driver> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }   
}
