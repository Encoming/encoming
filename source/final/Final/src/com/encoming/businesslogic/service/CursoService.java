/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.businesslogic.service;

import com.encoming.vo.CursoVo;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class CursoService implements IService<CursoVo> {
    private static CursoService instance;

    private CursoService() {
    }

    public static synchronized CursoService getInstance() {
        if (instance == null) {
            instance = new CursoService();
        }
        return instance;
    }

    @Override
    public void create(CursoVo vo, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CursoVo find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(CursoVo vo, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<CursoVo> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
