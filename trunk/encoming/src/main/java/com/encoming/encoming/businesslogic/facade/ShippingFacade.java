/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.facade;

import com.encoming.encoming.businesslogic.service.ShippingService;
import com.encoming.encoming.vo.ShippingVo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Andrezz
 */
public class ShippingFacade extends Facade<ShippingVo> {
    
    public ShippingFacade(String PUName, ShippingService service){
        super(PUName, service);
    }    

    public Integer findMaxIdShipping() {
        try {
            em = emf.createEntityManager();
            return ((ShippingService) service).findMaxIdShipping(em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }
    
      public List<ShippingVo> findToLess(Object point, Object idveh){
        try {
            em = emf.createEntityManager();
            return ((ShippingService)service).findToLess(point, idveh, em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }
      
      
      public void updateArrivedDate(Object arrivedDate,Object idShipping) {


        EntityTransaction tx = em.getTransaction();
        try {

        tx = em.getTransaction();

        tx.begin();

        ((ShippingService)service).updateArrivedDate(arrivedDate, idShipping, em);

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
    
}
