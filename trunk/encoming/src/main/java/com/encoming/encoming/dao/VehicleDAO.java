/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.dao;

import com.encoming.encoming.entity.Vehicle;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Andrezz
 */
public class VehicleDAO implements IDAO<Vehicle>{
    
    private static VehicleDAO instance;
    
    public static synchronized VehicleDAO getInstance() {
        if (instance == null) {
            instance = new VehicleDAO();
        }
        return instance;
    }
    
    @Override
    public void persist(Vehicle entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }    
    
    @Override
    public Vehicle find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void update(Vehicle entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public List<Vehicle> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
