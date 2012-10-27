/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.service;

import com.encoming.encoming.vo.PersonVo;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class PersonService implements IService<PersonVo> {
    private static  PersonService instance;
    
    public static synchronized PersonService getInstance() {
        if (instance == null) {
            instance = new PersonService();
        }
        return instance;
    }

    @Override
    public void persist(PersonVo vo, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PersonVo find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(PersonVo vo, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<PersonVo> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
/*
    public PersonVo login(PersonVo personVo, EntityManager em) {
        Person entity = new Person();
        
        entity.setIdPerson(personVo.getIdPerson());
        entity.setPassword(personVo.getPassword());
        
        Person person= new PersonDAO().login(entity, em);
        return person != null? person.toVo():null;
    }
    * */
       
}
