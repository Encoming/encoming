/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.dao;

import com.encoming.encoming.entity.Point;
import com.encoming.encoming.entity.Vehicle;
import com.encoming.encoming.vo.VehicleVo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Andrezz
 */
public class VehicleDAO implements IDAO<Vehicle> {

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
        return (Vehicle) query.getSingleResult();

    }
    
    public Integer findFreeVehicle (Integer idPoint, EntityManager em) {
        javax.persistence.Query query = em.createQuery("SELECT Min(v.idVehicle) FROM Vehicle v"
                + " WHERE v.status='disponible' AND v.point.idPoint=:idPoint")
                .setParameter("idPoint", idPoint);
        return (Integer)query.getSingleResult();
    }

    @Override
    public void update(Vehicle entity, EntityManager em) {
        em.merge(entity);
    }

    @Override
    public void delete(Object id, EntityManager em) {
        Vehicle vehicle = find(id, em);
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
    
    public void updatePoint(Point point, Object id, EntityManager em){
    em.createQuery("UPDATE Vehicle veh SET veh.point =:pointt WHERE veh.idVehicle =:idveh")
            .setParameter("idveh", id).setParameter("pointt", point)
            .executeUpdate();

            }
    public List<Vehicle> getListByPoint(Object idPoint, EntityManager em){
        Query query = em.createQuery("SELECT veh FROM Vehicle veh WHERE"
                + " veh.point.idPoint =: idpoint").setParameter("idpoint",idPoint);
        return (List<Vehicle>)query.getResultList();
    }
    }
