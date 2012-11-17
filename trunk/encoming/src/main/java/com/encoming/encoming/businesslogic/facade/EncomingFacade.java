/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.facade;

import com.encoming.encoming.businesslogic.service.EncomingService;
import com.encoming.encoming.vo.EncomingVo;
import java.util.List;

/**
 *
 * @author Andrezz
 */
public class EncomingFacade extends Facade<EncomingVo> {

    public EncomingFacade(String PUName, EncomingService service) {
        super(PUName, service);
    }

    public Integer findMaxIdEncoming() {
        try {
            em = emf.createEntityManager();
            Integer a;
            return ((EncomingService) service).findMaxIdEncoming(em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }
}
