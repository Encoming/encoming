/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.facade;

import com.encoming.encoming.businesslogic.service.AdministratorService;
import com.encoming.encoming.vo.AdministratorVo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class AdministratorFacade extends Facade<AdministratorVo> {

    public AdministratorFacade(String PUName, AdministratorService service) {
        super(PUName, service);
    }
    
    public AdministratorVo login(AdministratorVo administratorVo) {
        try {
            em = emf.createEntityManager();
            return ((AdministratorService)service).login(administratorVo, em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }

}
