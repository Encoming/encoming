/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.dao;

import com.encoming.encoming.entity.Vehicle;
import com.encoming.encoming.vo.VehicleVo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

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
        em.persist(entity);
    }    
    
    @Override
    public Vehicle find(Object id, EntityManager em) {
        Query query = em.createNamedQuery("Vehicle.findByIdVehicle")
                .setParameter("idVehicle", id);
        return(Vehicle) query.getSingleResult();
        
            }
    
    @Override
    public void update(Vehicle entity, EntityManager em) {
        em.merge(entity);
    }
    
    @Override
    public void delete(Object id, EntityManager em) {
        Vehicle vehicle = find(id,em);
        em.remove(vehicle);
    }
    
    @Override
    public List<Vehicle> getList(EntityManager em) {
        Query query = em.createNamedQuery("Vehicle.findAll");
        List<Vehicle> list = query.getResultList();
        return list;
    }
    
    public VehicleVo findByPlate(EntityManager em, Object plateNumbers, Object plateLetters){
        
        Query q = em.createQuery("SELECT veh FROM Vehicle veh WHERE"
                + " veh.plateLetters =:letters AND veh.plateNumber =:numbers")
                .setParameter("letters", plateLetters)
                .setParameter("numbers", plateNumbers);
        
        Vehicle veh = (Vehicle)q.getSingleResult();
        
        VehicleVo vehVo = veh.toVo();
        
        
        System.out.println("vehVo" + vehVo.getPlateLetters());
        return vehVo;
    }
    
}
