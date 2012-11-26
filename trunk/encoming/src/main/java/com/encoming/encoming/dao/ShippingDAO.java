/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.dao;

import com.encoming.encoming.entity.Shipping;
import com.encoming.encoming.vo.ShippingVo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Andrezz
 */
public class ShippingDAO implements IDAO<Shipping> {

    private static ShippingDAO instance;

    public static synchronized ShippingDAO getInstance() {
        if (instance == null) {
            instance = new ShippingDAO();
        }
        return instance;
    }

    @Override
    public void persist(Shipping entity, EntityManager em) {
        try {
            em.persist(entity);
        } catch (Exception e) {
        }
    }

    @Override
    public Shipping find(Object idA, EntityManager em) {
        Integer id = (Integer) idA;
        javax.persistence.Query query = em.createQuery("SELECT shi FROM Shipping shi "
                + "WHERE shi.idShipping =:idShipping")
                .setParameter("idShipping", id);
        return (Shipping) query.getSingleResult();
    }
    
    public Integer finMaxIdShipping(EntityManager em) {
        javax.persistence.Query query = em.createQuery("SELECT Max(s.idShipping) FROM Shipping s");
        return (Integer)query.getSingleResult();
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
    
    public ShippingVo findToGive(EntityManager em, Object idDestinationCity){
        Query q = em.createQuery("SELECT ship FROM Shipping ship WHERE "
                + "ship.route.destinationCity =:city").setParameter("city", idDestinationCity);
        
        return null;
        
        
    }
    
    public List<Shipping> findToLess(Object point, Object idVehicle, EntityManager em){
        System.out.println("entra a hacer la consulta");
        Query q = em.createQuery("SELECT ship FROM Shipping ship WHERE ship.route.destinationPoint.idPoint =:city AND ship.vehicle.idVehicle =:idVehicle AND ship.arrivedDate IS NULL").setParameter("city", point).setParameter("idVehicle",idVehicle);
        System.out.println("si hace la consulta");
        return (List<Shipping>) q.getResultList();
        
    }
   
    
    public void updateArrivedDate(Object arrivedDate,Object idShipping, EntityManager em){
    em.createQuery("UPDATE Shipping shi SET shi.arrivedDate =:arrivedDate WHERE shi.idShipping =:idShip")
            .setParameter("idShip", idShipping).setParameter("arrivedDate", arrivedDate)
            .executeUpdate();

            }
    }



