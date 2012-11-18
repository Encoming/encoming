/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.facade;

import com.encoming.encoming.businesslogic.service.ShippingService;
import com.encoming.encoming.vo.ShippingVo;

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
    
}
