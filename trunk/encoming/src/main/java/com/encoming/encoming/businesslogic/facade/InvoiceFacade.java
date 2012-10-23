/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.facade;

import com.encoming.encoming.businesslogic.service.InvoiceService;
import com.encoming.encoming.vo.InvoiceVo;

/**
 *
 * @author Andrezz
 */
public class InvoiceFacade extends Facade<InvoiceVo> {
    
    public InvoiceFacade(String PUName, InvoiceService service){
        super(PUName, service);
    }    
    
}
