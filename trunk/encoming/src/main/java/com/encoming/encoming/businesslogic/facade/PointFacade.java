/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.facade;

import com.encoming.encoming.businesslogic.service.PointService;
import com.encoming.encoming.vo.PointVo;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class PointFacade extends Facade<PointVo> {

    public PointFacade(String PUName, PointService service) {
        super(PUName, service);
    }
}
