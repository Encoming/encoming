/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.businesslogic.facade;

import com.encoming.businesslogic.service.CursoService;
import com.encoming.vo.CursoVo;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class CursoFacade extends Facade<CursoVo> {
    public CursoFacade(String PUName, CursoService service) {
        super(PUName, service);
    }
}
