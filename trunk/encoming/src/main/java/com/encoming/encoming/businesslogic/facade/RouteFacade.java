/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.facade;

import com.encoming.encoming.businesslogic.service.RouteService;
import com.encoming.encoming.vo.RouteVo;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Andrezz
 */
public class RouteFacade extends Facade<RouteVo> {
    
    protected RouteService service = new RouteService();
    
    public RouteFacade(String PUName, RouteService service){
        super(PUName, service);
    }    

    public void updateKm(Integer idRoute,double numberKilometers) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx = em.getTransaction();   
            tx.begin();
            service.updateKm(idRoute,numberKilometers,em);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em != null && tx != null) {
                tx.rollback();
            }
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }
    public Integer findIdRoute(Object originCity, Object destinationCity) {
        try {
            em = emf.createEntityManager();
            return ((RouteService) service).findIdRoute(originCity,destinationCity,em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }

    public Integer findNewIdRoute() {
        try {
            em = emf.createEntityManager();
            return ((RouteService) service).findNewIdRoute(em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }

    
}
