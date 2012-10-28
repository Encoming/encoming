/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.AdministratorFacade;
import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.vo.AdministratorVo;

/**
 *
 * @author THOKK
 */
public class FindEmployeeBean {
    Integer documento;

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }
    public AdministratorVo find(){
        AdministratorFacade adminFac = FacadeFactory.getInstance().getAdministratorFacade();
        AdministratorVo adminVo = adminFac.find(this.documento);
        return adminVo;
    }
    
}
