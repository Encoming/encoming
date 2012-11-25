/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.businesslogic.facade;

import com.encoming.businesslogic.service.InscripcionService;
import com.encoming.businesslogic.service.ServiceFactory;
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
            service.inscribirEstudiante(nombreEstudiante, nombreMateria,em);
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
}
