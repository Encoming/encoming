/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.service;

import com.encoming.encoming.dao.DAOFactory;
import com.encoming.encoming.entity.Encoming;
import com.encoming.encoming.vo.EncomingVo;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author FAMILIA
 */
public class EncomingService implements IService<EncomingVo>{
    
    private static EncomingService instance;

    public static synchronized EncomingService getInstance() {
        if (instance == null) {
            instance = new EncomingService();
        }
        return instance;
    }

    @Override
    public void persist(EncomingVo vo, EntityManager em) {
        Encoming entity = new Encoming();
        entity.setType(vo.getType());
        entity.setVolume(vo.getVolume());
        entity.setPriority(vo.getPriority());
        entity.setWeight(vo.getWeight());

        DAOFactory.getInstance().getEncomingDAO().persist(entity, em);
    }

    @Override
    public EncomingVo find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(EncomingVo vo, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<EncomingVo> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
