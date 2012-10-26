/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.facade;

import com.encoming.encoming.businesslogic.service.RouteService;
import com.encoming.encoming.vo.RouteVo;

/**
 *
 * @author Andrezz
 */
public class RouteFacade extends Facade<RouteVo> {
    
    public RouteFacade(String PUName, RouteService service){
        super(PUName, service);
    }    
    
}
