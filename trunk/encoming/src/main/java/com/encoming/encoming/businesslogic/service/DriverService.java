/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.service;

import com.encoming.encoming.dao.DAOFactory;
import com.encoming.encoming.dao.DriverDAO;
import com.encoming.encoming.dao.PersonDAO;
import com.encoming.encoming.entity.Driver;
import com.encoming.encoming.entity.Person;
import com.encoming.encoming.vo.DriverVo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author FAMILIA
 */
public class DriverService implements IService<DriverVo> {
    
    private static DriverService instance;

    public static synchronized DriverService getInstance() {
        if (instance == null) {
            instance = new DriverService();
        }
        return instance;
    }

    @Override
    public void persist(DriverVo vo, EntityManager em) {
        PersonDAO persondao= DAOFactory.getInstance().getPersonDAO();
        DriverDAO dao = DAOFactory.getInstance().getDriverDAO();
        Driver driver =  new Driver();
        driver.setIdDriver(vo.getIdDriver());
        Person person = persondao.find(vo.getPersonId(), em);
        driver.setPersonidPerson(person);
        driver.setLicense(vo.getLicense());
        dao.persist(driver, em);
    }

    @Override
    public DriverVo find(Object id, EntityManager em) {
        DriverDAO dao = DAOFactory.getInstance().getDriverDAO();
        DriverVo adminvo = dao.find(id, em).toVo();
        return adminvo;
    }

    @Override
    public void update(DriverVo vo, EntityManager em) {
        PersonDAO persondao= DAOFactory.getInstance().getPersonDAO();
        DriverDAO dao = DAOFactory.getInstance().getDriverDAO();
        Driver driver =  new Driver();
        driver.setIdDriver(vo.getIdDriver());
        Person person = persondao.find(vo.getPersonId(), em);
        driver.setPersonidPerson(person);
        driver.setLicense(vo.getLicense());
        dao.update(driver, em);
    }

    @Override
    public void delete(Object id, EntityManager em) {
        DriverDAO dao = DAOFactory.getInstance().getDriverDAO();
        dao.delete(id, em);
    }

    @Override
    public List<DriverVo> getList(EntityManager em) {
        DriverDAO dao =  DAOFactory.getInstance().getDriverDAO();
        List<Driver> lista = dao.getList(em);
        ArrayList<DriverVo> drivers = new ArrayList();
        for(Driver p : lista){
            drivers.add(p.toVo());
        }
        return drivers;
    }
    public DriverVo findById(Object id, EntityManager em){
         return DAOFactory.getInstance().getDriverDAO().find(id, em).toVo();
    }
    
}
