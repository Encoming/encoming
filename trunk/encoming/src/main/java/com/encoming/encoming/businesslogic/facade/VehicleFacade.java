/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.facade;

import com.encoming.encoming.businesslogic.service.VehicleService;
import com.encoming.encoming.vo.VehicleVo;

/**
 *
 * @author Andrezz
 */
public class VehicleFacade extends Facade<VehicleVo> {
    
    public VehicleFacade(String PUName, VehicleService service){
        super(PUName, service);
    }    
    
}
