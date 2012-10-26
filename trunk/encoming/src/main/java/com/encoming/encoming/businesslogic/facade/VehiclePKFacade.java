/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.facade;

import com.encoming.encoming.businesslogic.service.VehiclePKService;
import com.encoming.encoming.vo.VehiclePKVo;

/**
 *
 * @author Andrezz
 */
public class VehiclePKFacade extends Facade<VehiclePKVo> {
    
    public VehiclePKFacade(String PUName, VehiclePKService service){
        super(PUName, service);
    }    
    
}
