/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.businesslogic.facade;

import com.encoming.businesslogic.service.InscripcionService;
import com.encoming.businesslogic.service.ServiceFactory;
import com.encoming.utils.NoPrerrequisitosException;
import com.encoming.vo.CursoVo;
import com.encoming.vo.EstudianteVo;
import com.encoming.vo.InscripcionVo;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class InscripcionFacade extends Facade<InscripcionVo> {

    protected InscripcionService service = ServiceFactory.getInstance().getInscripcionService();

    public InscripcionFacade(String PUName, InscripcionService service) {
        super(PUName, service);
    }

    public void inscribirEstudiante(String nombreEstudiante, String nombreMateria) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx = em.getTransaction();
            tx.begin();
            service.inscribirEstudiante(nombreEstudiante, nombreMateria, em);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em != null && tx != null) {
                tx.rollback();
            }
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }

    public boolean estudianteCumplePreRequisitos(EstudianteVo estudianteVo, CursoVo cursoVo) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        boolean ret = false;
        try {
            tx = em.getTransaction();
            tx.begin();
            tx.commit();
            ret = service.estudianteCumplePreRequisitos(estudianteVo, cursoVo, em);
        } catch (Exception e) {
            e.printStackTrace();
            if (em != null && tx != null) {
                tx.rollback();
            }
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
            return ret;
        }
    }

    public boolean estudianteCumplePreRequisitos(Integer id, Integer prerequisitoCursoId)throws NoPrerrequisitosException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        boolean ret = false;
        try {
            tx = em.getTransaction();
            tx.begin();
            tx.commit();
            ret = service.estudianteCumplePreRequisitos(id, prerequisitoCursoId, em);
            if(ret==false)throw new NoPrerrequisitosException("El estudiante no cumple con los prerequisitos");
        } catch (Exception e) {
            if (em != null && tx != null) {
                tx.rollback();
            }
            throw new NoPrerrequisitosException("El estudiante no cumple con los prerequisitos");
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
            return ret;
        }
    }
}
