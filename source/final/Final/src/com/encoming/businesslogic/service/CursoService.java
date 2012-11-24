/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.businesslogic.service;

import com.encoming.dao.CursoDAO;
import com.encoming.dao.DAOFactory;
import com.encoming.dao.InscripcionDAO;
import com.encoming.entity.Cursos;
import com.encoming.entity.Inscripciones;
import com.encoming.vo.CursoVo;
import com.encoming.vo.InscripcionVo;
import java.util.ArrayList;
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
        ArrayList<Inscripciones> inscripciones = new ArrayList();
        Cursos curso = new Cursos();
        CursoDAO cursoNew = DAOFactory.getInstance().getCursoDAO();
        curso.setId(vo.getId());
        curso.setNombre(vo.getNombre());
        curso.setValorCurso(vo.getValorCurso());
        CursoDAO cursoPre = DAOFactory.getInstance().getCursoDAO();
        curso.setPrerequisito(cursoPre.find(vo.getPrerequisitoCursoId(), em));
        for(InscripcionVo ins : vo.getInscripcionesList()){
            InscripcionDAO insDao = DAOFactory.getInstance().getInscripcionDAO();
            inscripciones.add(insDao.find(ins.getId(), em));
            }
        curso.setInscripcionesList(inscripciones);
        cursoNew.persist(curso, em);
    }

    @Override
    public CursoVo find(Object id, EntityManager em) {
        CursoVo cursoVo = DAOFactory.getInstance().getCursoDAO().find(id, em).toVo();
        return cursoVo;
    }

    @Override
    public void update(CursoVo vo, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        DAOFactory.getInstance().getCursoDAO().delete(id, em);
    }

    @Override
    public List<CursoVo> getList(EntityManager em) {
        List<Cursos> cursos =  DAOFactory.getInstance().getCursoDAO().getList(em);
        ArrayList<CursoVo> cursosVo = new ArrayList();
        for (Cursos cur:cursos){
            cursosVo.add(cur.toVo());
        
        }
        return cursosVo;
    }
}
