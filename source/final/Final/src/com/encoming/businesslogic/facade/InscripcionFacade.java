/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.businesslogic.facade;

import com.encoming.businesslogic.service.InscripcionService;
import com.encoming.vo.InscripcionVo;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class InscripcionFacade extends Facade<InscripcionVo> {
    public InscripcionFacade(String PUName, InscripcionService service) {
        super(PUName, service);
    }
}
