/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.businesslogic.service;

import com.encoming.vo.InscripcionVo;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class InscripcionService implements IService<InscripcionVo> {
    private static InscripcionService instance;

    private InscripcionService() {
    }

    public static synchronized InscripcionService getInstance() {
        if (instance == null) {
            instance = new InscripcionService();
        }
        return instance;
    }

    @Override
    public void create(InscripcionVo vo, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public InscripcionVo find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(InscripcionVo vo, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<InscripcionVo> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
