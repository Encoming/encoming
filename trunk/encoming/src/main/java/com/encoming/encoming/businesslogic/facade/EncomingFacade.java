/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.facade;

import com.encoming.encoming.businesslogic.service.EncomingService;
import com.encoming.encoming.vo.EncomingVo;

/**
 *
 * @author Andrezz
 */
public class EncomingFacade extends Facade<EncomingVo> {
    
    public EncomingFacade(String PUName, EncomingService service){
        super(PUName, service);
    }    
    
}
