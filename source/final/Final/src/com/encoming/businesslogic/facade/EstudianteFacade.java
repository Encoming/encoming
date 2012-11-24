/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.businesslogic.facade;

import com.encoming.businesslogic.service.EstudianteService;
import com.encoming.vo.EstudianteVo;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class EstudianteFacade extends Facade<EstudianteVo> {
    public EstudianteFacade(String PUName, EstudianteService service) {
        super(PUName, service);
    }

    public Object findByDocument(String documento) {
        try {
            return ((EstudianteService) service).findByDocument(documento, em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }
}
