/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.dao;

import com.encoming.encoming.entity.Shipping;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Andrezz
 */
public class ShippingDAO implements IDAO<Shipping>{
    
    private static ShippingDAO instance;
    
    public static synchronized ShippingDAO getInstance() {
        if (instance == null) {
            instance = new ShippingDAO();
        }
        return instance;
    }
    
    @Override
    public void persist(Shipping entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }    
    
    @Override
    public Shipping find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void update(Shipping entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public List<Shipping> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
