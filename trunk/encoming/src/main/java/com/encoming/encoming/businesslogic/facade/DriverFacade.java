/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.facade;

import com.encoming.encoming.businesslogic.service.DriverService;
import com.encoming.encoming.vo.DriverVo;

/**
 *
 * @author Andrezz
 */
public class DriverFacade extends Facade<DriverVo> {
    
    public DriverFacade(String PUName, DriverService service){
        super(PUName, service);
    }
    public DriverVo findByName(Object id){
        try {
            em = emf.createEntityManager();
            return ((DriverService)service).findById(id,em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }
    
}
