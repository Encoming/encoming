/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.service;

import com.encoming.encoming.dao.AdministratorDAO;
import com.encoming.encoming.entity.Administrator;
import com.encoming.encoming.vo.AdministratorVo;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AdministratorVo find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(AdministratorVo vo, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<AdministratorVo> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public AdministratorVo login(AdministratorVo administratorVo, EntityManager em) {
        Administrator entity = new Administrator();
        
        entity.setUsername(administratorVo.getUsername());
        entity.setPassword(administratorVo.getPassword());
        
        Administrator administrator= new AdministratorDAO().login(entity, em);
        return administrator != null? administrator.toVo():null;
    }
}
