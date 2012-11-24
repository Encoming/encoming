/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.businesslogic.service;

import com.encoming.dao.DAOFactory;
import com.encoming.entity.Estudiantes;
import com.encoming.vo.EstudianteVo;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class EstudianteService implements IService<EstudianteVo> {
    private static EstudianteService instance;

    private EstudianteService() {
    }

    public static synchronized EstudianteService getInstance() {
        if (instance == null) {
            instance = new EstudianteService();
        }
        return instance;
    }

    @Override
    public void create(EstudianteVo vo, EntityManager em) {
        Estudiantes estudiante = new Estudiantes();
        estudiante.setActivo(vo.getActivo());
        estudiante.setDocumento(vo.getDocumento());
        estudiante.setFechaNacimiento(vo.getFechaNacimiento());
        estudiante.setNombre(vo.getNombre());
        
        DAOFactory.getInstance().getEstudianteDAO().persist(estudiante, em);
    }

    @Override
    public EstudianteVo find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(EstudianteVo vo, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<EstudianteVo> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
}
