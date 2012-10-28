/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.service;

import com.encoming.encoming.dao.AdministratorDAO;
import com.encoming.encoming.dao.DAOFactory;
import com.encoming.encoming.dao.PersonDAO;
import com.encoming.encoming.entity.Administrator;
import com.encoming.encoming.entity.Person;
import com.encoming.encoming.vo.AdministratorVo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class AdministratorService implements IService<AdministratorVo> {

    private static AdministratorService instance;

    public static synchronized AdministratorService getInstance() {
        if (instance == null) {
            instance = new AdministratorService();
        }
        return instance;
    }

    @Override
    public void persist(AdministratorVo vo, EntityManager em) {
        PersonDAO persondao= new PersonDAO(); 
        
        Administrator admin =  new Administrator();
        admin.setIdAdministrator(vo.getIdAdministrator());
        Person person = persondao.find(vo.getPersonidPerson(), em);
        admin.setPersonidPerson(person);
        admin.setPassword(vo.getPassword());
        admin.setUsername(vo.getUsername());

        DAOFactory.getInstance().getAdministratorDAO().persist(admin, em);
        
    }

    @Override
    public AdministratorVo find(Object id, EntityManager em) {
        
        AdministratorVo adminvo = DAOFactory.getInstance().getAdministratorDAO().find(id, em).toVo();
        return adminvo;
    }

    @Override
    public void update(AdministratorVo vo, EntityManager em) {
        
        Administrator admin =  new Administrator();
        admin.setIdAdministrator(vo.getIdAdministrator());
        Person person = DAOFactory.getInstance().getPersonDAO().find(vo.getPersonidPerson(), em);
        admin.setPersonidPerson(person);
        admin.setPassword(vo.getPassword());
        admin.setUsername(vo.getUsername());
    
        DAOFactory.getInstance().getAdministratorDAO().update(admin, em);
    }

    @Override
    public void delete(Object id, EntityManager em) {
       DAOFactory.getInstance().getAdministratorDAO().delete(id, em);
    }

    @Override
    public List<AdministratorVo> getList(EntityManager em) {
        AdministratorDAO dao =  DAOFactory.getInstance().getAdministratorDAO();
        List<Administrator> lista = dao.getList(em);
        ArrayList<AdministratorVo> admins = new ArrayList();
        for(Administrator p : lista){
            admins.add(p.toVo());
        }
        return admins;
    }   
    
    
    public AdministratorVo login(AdministratorVo administratorVo, EntityManager em) {
        Administrator entity = new Administrator();
        
        entity.setUsername(administratorVo.getUsername());
        entity.setPassword(administratorVo.getPassword());
        
        Administrator administrator = DAOFactory.getInstance().getAdministratorDAO().login(entity, em);
        return administrator != null? administrator.toVo():null;
    }
}
