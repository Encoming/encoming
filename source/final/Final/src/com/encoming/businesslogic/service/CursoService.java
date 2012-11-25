/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.businesslogic.service;

import com.encoming.dao.DAOFactory;
import com.encoming.entity.Cursos;
import com.encoming.entity.Inscripciones;
import com.encoming.vo.CursoVo;
import com.encoming.vo.InscripcionVo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        
        Cursos curso = new Cursos();
        
        curso.setInscripcionesList(new ArrayList<Inscripciones>());
        curso.setNombre(vo.getNombre());
        curso.setPrerequisito(DAOFactory.getInstance().getCursoDAO().findById(vo.getPrerequisitoCursoId(), em));
        curso.setValorCurso(vo.getValorCurso());
        
        DAOFactory.getInstance().getCursoDAO().persist(curso, em);
        
        
//        CursoDAO cursoNew = DAOFactory.getInstance().getCursoDAO();
//        curso.setId(vo.getId());
//        curso.setNombre(vo.getNombre());
//        curso.setValorCurso(vo.getValorCurso());
//        CursoDAO cursoPre = DAOFactory.getInstance().getCursoDAO();
//        curso.setPrerequisito(cursoPre.find(vo.getPrerequisitoCursoId(), em));
//        //for(InscripcionVo ins : vo.getInscripcionesList()){
//        //    InscripcionDAO insDao = DAOFactory.getInstance().getInscripcionDAO();
//         //   inscripciones.add(insDao.find(ins.getId(), em));
//         //   }
//        curso.setInscripcionesList(inscripciones);
//        cursoNew.persist(curso, em);
    }

    @Override
    public CursoVo find(Object id, EntityManager em) {
        CursoVo cursoVo = DAOFactory.getInstance().getCursoDAO().find(id, em).toVo();
        return cursoVo;
    }

    @Override
    public void update(CursoVo vo, EntityManager em) {
        Cursos curso = DAOFactory.getInstance().getCursoDAO().findById(vo.getId(), em);
        List<InscripcionVo> inscripcionVos = vo.getInscripcionesList();
        InscripcionVo ins = inscripcionVos.get(inscripcionVos.size()-1);
        Inscripciones inscripcion = DAOFactory.getInstance().getInscripcionDAO().findSubscriptionByStudentAndCourse(
                ins.getEstudianteId(), ins.getCursoId(), em);
        curso.setId(vo.getId());   
        List<Inscripciones> inscripciones=curso.getInscripcionesList();
        inscripciones.add(inscripcion);
        curso.setInscripcionesList(inscripciones);
        curso.setNombre(vo.getNombre());
        
        Cursos prerequisito = DAOFactory.getInstance().getCursoDAO().findById(vo.getPrerequisitoCursoId(), em);
        curso.setPrerequisito(prerequisito);
        
        curso.setValorCurso(vo.getValorCurso());
        
        DAOFactory.getInstance().getCursoDAO().update(curso, em);
    }

    @Override
    public void delete(Object id, EntityManager em) {
        DAOFactory.getInstance().getCursoDAO().delete(id, em);
    }

    @Override
    public List<CursoVo> getList(EntityManager em) {
        List<CursoVo> list = new ArrayList<CursoVo>();
        for (Cursos curso : DAOFactory.getInstance().getCursoDAO().getList(em)) {
            list.add((curso).toVo());
        }
        Collections.sort(list, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                CursoVo p1 = (CursoVo) o1;
                CursoVo p2 = (CursoVo) o2;
                return p1.getId().compareTo(p2.getId());
            }
        });
        return list;
    }

    public CursoVo findByName(String nombreMateria, EntityManager em) {
        Cursos curso = DAOFactory.getInstance().getCursoDAO().findByName(nombreMateria, em);
        if (curso.getNombre() != null) {
            return curso.toVo();
        } else {
            return null;
        }
    }

    public CursoVo findById(Integer cursoId, EntityManager em) {
        Cursos curso = DAOFactory.getInstance().getCursoDAO().findById(cursoId, em);
        if (curso.getNombre() != null) {
            return curso.toVo();
        } else {
            return null;
        }
    }
}
