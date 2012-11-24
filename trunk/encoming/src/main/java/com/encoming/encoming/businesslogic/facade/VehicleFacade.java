/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.facade;

import com.encoming.encoming.businesslogic.service.VehicleService;
import com.encoming.encoming.vo.AdministratorVo;
import com.encoming.encoming.vo.VehicleVo;
import java.util.ArrayList;

/**
 *
 * @author Andrezz
 */
public class VehicleFacade extends Facade<VehicleVo> {
    
    public VehicleFacade(String PUName, VehicleService service){
        super(PUName, service);
    }    
        public VehicleVo findByPlate (Object plateNumbers, Object PlateLetters){
         try {
            em = emf.createEntityManager();
            return ((VehicleService)service).findByPlate(em,plateNumbers,PlateLetters);
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
            return ((VehicleService) service).findFreeVehicle(idPoint,em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }
        
}

