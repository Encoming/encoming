/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.facade;

import com.encoming.encoming.businesslogic.service.VehicleService;
import com.encoming.encoming.vo.AdministratorVo;
import com.encoming.encoming.vo.VehicleVo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Andrezz
 */
public class VehicleFacade extends Facade<VehicleVo> {

    public VehicleFacade(String PUName, VehicleService service) {
        super(PUName, service);
    }

    public VehicleVo findByPlate(Object plateNumbers, Object PlateLetters) {
        try {
            em = emf.createEntityManager();
            return ((VehicleService) service).findByPlate(em, plateNumbers, PlateLetters);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }

    public Integer findFreeVehicle(Integer idPoint) {
        try {
            em = emf.createEntityManager();
            return ((VehicleService) service).findFreeVehicle(idPoint, em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }

    public void updatePoint(Object idPoint, Object id) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx = em.getTransaction();
            tx.begin();
            ((VehicleService) service).updatePoint(idPoint, id, em);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em != null && tx != null) {
                tx.rollback();
            }
        } 
        
        
        public List<VehicleVo> getListByPoint(Object idPoint){
             try {
            em = emf.createEntityManager();
            return ((VehicleService) service).getListByPoint(idPoint, em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
        }
        
}
