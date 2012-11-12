/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.facade;

import com.encoming.encoming.businesslogic.service.ClientService;
import com.encoming.encoming.vo.ClientVo;

/**
 *
 * @author Andrezz
 */
public class ClientFacade extends Facade<ClientVo> {
    
    public ClientFacade(String PUName, ClientService service){
        super(PUName, service);
    }    
    
}
