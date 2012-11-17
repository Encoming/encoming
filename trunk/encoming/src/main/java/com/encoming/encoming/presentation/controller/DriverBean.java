/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.vo.DriverVo;
import com.encoming.encoming.vo.PersonVo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class DriverBean {

    private List<SelectItem> drivers;

    /**
     * Creates a new instance of DriverBean
     */
    public DriverBean() {
    }

    public List<SelectItem> getDrivers() {
        if (drivers == null) {
            drivers = new ArrayList<SelectItem>();
            List<DriverVo> driverList = FacadeFactory.getInstance().getDriverFacade().getList();
            if (driverList != null) {
                for (DriverVo driver : driverList) {
                    PersonVo person = FacadeFactory.getInstance().getPersonFacade().find(driver.getPersonId());
                    drivers.add(new SelectItem(driver.getIdDriver(),
                            person.getName() + " " + person.getLastName()));
                }
            }
        }
        return drivers;
    }
}
