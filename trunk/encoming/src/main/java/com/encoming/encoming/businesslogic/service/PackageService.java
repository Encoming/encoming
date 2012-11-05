/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.service;

import com.encoming.encoming.dao.DAOFactory;
import com.encoming.encoming.entity.Package;
import com.encoming.encoming.vo.PackageVo;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author FAMILIA
 */
public class PackageService implements IService<PackageVo>{
    
    private static PackageService instance;

    public static synchronized PackageService getInstance() {
        if (instance == null) {
            instance = new PackageService();
        }
        return instance;
    }

    @Override
    public void persist(PackageVo vo, EntityManager em) {
        Package entity = new Package();
        entity.setType(vo.getType());
        entity.setVolume(vo.getVolume());
        entity.setPriority(vo.getPriority());
        entity.setWeight(vo.getWeight());

        DAOFactory.getInstance().getPackageDAO().persist(entity, em);
    }

    @Override
    public PackageVo find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(PackageVo vo, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<PackageVo> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
