/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.service;

import com.encoming.encoming.dao.DAOFactory;
import com.encoming.encoming.dao.PersonDAO;
import com.encoming.encoming.entity.Person;
import com.encoming.encoming.vo.PersonVo;
import java.util.ArrayList;
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
        Person person = new Person();
        person.setName(vo.getName());
        person.setAdress(vo.getAdress());
        person.setIdPerson(vo.getIdPerson());
        person.setLastanames(vo.getLastName());
        person.setMail(vo.getLastName());
        person.setPhone(vo.getPhone());
        DAOFactory.getInstance().getPersonDAO().persist(person, em);
               
    }

    @Override
    public PersonVo find(Object id, EntityManager em) {
        PersonDAO dao = DAOFactory.getInstance().getPersonDAO();
        PersonVo personvo = dao.find(id, em).toVo();
        return personvo;
    }

    @Override
    public void update(PersonVo vo, EntityManager em) {
        Person person = new Person();
        PersonDAO dao = DAOFactory.getInstance().getPersonDAO();
        person.setName(vo.getName());
        person.setAdress(vo.getAdress());
        person.setIdPerson(vo.getIdPerson());
        person.setLastanames(vo.getLastName());
        person.setMail(vo.getLastName());
        person.setPhone(vo.getPhone());
        dao.update(person, em);
    }

    @Override
    public void delete(Object id, EntityManager em) {
        PersonDAO dao =  DAOFactory.getInstance().getPersonDAO();
        dao.delete(id, em);
    }

    @Override
    public List<PersonVo> getList(EntityManager em) {
        PersonDAO dao =  DAOFactory.getInstance().getPersonDAO();
        List<Person> lista = dao.getList(em);
        ArrayList<PersonVo> personas = new ArrayList();
        for(Person p : lista){
            personas.add(p.toVo());
        }
        return personas;
    }   
}
