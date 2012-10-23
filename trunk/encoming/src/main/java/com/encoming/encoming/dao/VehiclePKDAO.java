/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.dao;

import com.encoming.encoming.entity.VehiclePK;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Tutas
 */
public class VehiclePKDAO implements IDAO<VehiclePK>{
    
    private static VehiclePKDAO instance;
    
    public static synchronized VehiclePKDAO getInstance() {
        if (instance == null) {
            instance = new VehiclePKDAO();
        }
        return instance;
    }
    
    @Override
    public void persist(VehiclePK entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }    
    
    @Override
    public VehiclePK find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void update(VehiclePK entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public List<VehiclePK> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
