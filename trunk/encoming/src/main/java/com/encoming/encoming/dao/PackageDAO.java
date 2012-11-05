/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.dao;

import com.encoming.encoming.entity.Package;
import java.util.List;
import javax.management.Query;
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
        em.persist(entity);
    }    
    
    @Override
    public Package find(Object idA, EntityManager em) {
        Integer id = (Integer) idA;
        javax.persistence.Query query = em.createNamedQuery("Package.findByIdPackage")
                .setParameter("idPackage", id);
        return (Package)query.getSingleResult();
    }
    
    @Override
    public void update(Package entity, EntityManager em) {
        em.merge(entity);
    }
    
    @Override
    public void delete(Object id, EntityManager em) {
        Package packageA = find(id,em);
        em.remove(packageA);
    }
    
    @Override
    public List<Package> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
