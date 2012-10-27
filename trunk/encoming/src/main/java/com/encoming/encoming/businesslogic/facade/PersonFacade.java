/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.facade;

import com.encoming.encoming.businesslogic.service.PersonService;
import com.encoming.encoming.vo.PersonVo;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class PersonFacade extends Facade<PersonVo> {
    
    public PersonFacade(String PUName, PersonService service){
        super(PUName, service);
    }
    
/*
    public PersonVo login(PersonVo personVo) {
        try {
            em = emf.createEntityManager();
            return ((PersonService)service).login(personVo, em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }
    * */
    
}
