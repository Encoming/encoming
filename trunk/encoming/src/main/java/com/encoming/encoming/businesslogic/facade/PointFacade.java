/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.facade;

import com.encoming.encoming.businesslogic.service.PointService;
import com.encoming.encoming.vo.PointVo;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class PointFacade extends Facade<PointVo> {

    public PointFacade(String PUName, PointService service) {
        super(PUName, service);
    }
    
    public PointVo findByName(Object name){
        try {
            em = emf.createEntityManager();
            return ((PointService)service).findByName(em,name);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }
    
     public Integer findIdPoint(String originCity) {
        try {
            em = emf.createEntityManager();
            Integer a;
            return ((PointService) service).findIdPoint(originCity, em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }

    public String findNamePoint(Integer idPoint) {
        try {
            em = emf.createEntityManager();
            return ((PointService) service).findNamePoint(idPoint, em);
        } finally {
            if(em != null) {
                em.clear();
                em.close();
            }
        }
    }
}
