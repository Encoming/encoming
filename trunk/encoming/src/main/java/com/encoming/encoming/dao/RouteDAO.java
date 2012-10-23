/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.dao;

import com.encoming.encoming.entity.Route;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Andrezz
 */
public class RouteDAO implements IDAO<Route>{
    
    private static RouteDAO instance;
    
    public static synchronized RouteDAO getInstance() {
        if (instance == null) {
            instance = new RouteDAO();
        }
        return instance;
    }
    
    @Override
    public void persist(Route entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }    
    
    @Override
    public Route find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void update(Route entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public List<Route> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
