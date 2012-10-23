/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.dao;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Tutas
 */
public class PackageDAO implements IDAO<Package>{
    
    private static PackageDAO instance;
    
    public static synchronized PackageDAO getInstance() {
        if (instance == null) {
            instance = new PackageDAO();
        }
        return instance;
    }
    
    @Override
    public void persist(Package entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }    
    
    @Override
    public Package find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void update(Package entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public List<Package> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
