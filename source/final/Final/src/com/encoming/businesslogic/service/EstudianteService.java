/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.businesslogic.service;

import com.encoming.dao.DAOFactory;
import com.encoming.entity.Estudiantes;
import com.encoming.vo.EstudianteVo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        List<EstudianteVo> list = new ArrayList<EstudianteVo>();
        for (Estudiantes estudiantes : DAOFactory.getInstance().getEstudianteDAO().getList(em)) {
            list.add((estudiantes).toVo());
        }
        Collections.sort(list, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                EstudianteVo p1 = (EstudianteVo) o1;
                EstudianteVo p2 = (EstudianteVo) o2;
                return p1.getId().compareTo(p2.getId());
            }
        });
        return list;
    }

    public EstudianteVo findByDocument(String documento, EntityManager em) {
        Estudiantes student = DAOFactory.getInstance().getEstudianteDAO().findByDocument(documento, em);
        if (student.getDocumento() != null) {
            return student.toVo();
        } else {
            return null;
        }
    }

    public EstudianteVo findByName(String nombreEstudiante, EntityManager em) {
        Estudiantes student = DAOFactory.getInstance().getEstudianteDAO().findByName(nombreEstudiante, em);
        if (student.getNombre() != null) {
            return student.toVo();
        } else {
            return null;
        }
    }

    public EstudianteVo findById(Integer estudianteId, EntityManager em) {
        Estudiantes student = DAOFactory.getInstance().getEstudianteDAO().findById(estudianteId, em);
        if (student.getNombre() != null) {
            return student.toVo();
        } else {
            return null;
        }
    }

   
}
