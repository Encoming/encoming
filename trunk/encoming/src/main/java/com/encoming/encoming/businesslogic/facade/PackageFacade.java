/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.facade;

import com.encoming.encoming.businesslogic.service.PackageService;
import com.encoming.encoming.vo.PackageVo;

/**
 *
 * @author Andrezz
 */
public class PackageFacade extends Facade<PackageVo> {
    
    public PackageFacade(String PUName, PackageService service){
        super(PUName, service);
    }    
    
}
