/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.vo.PointVo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author THOKK
 */
@ManagedBean
@RequestScoped
public class tableBeanPoint {

    private List<PointVo> points;
    private List<PointVo> filteredPoints;
    
    public tableBeanPoint() {
        
        points = new ArrayList<PointVo>();
        points = FacadeFactory.getInstance().getPointFacade().getList();
        
    }

    public List<PointVo> getPoints() {
        return points;
    }

    public void setPoints(List<PointVo> points) {
        this.points = points;
    }

    public List<PointVo> getFilteredPoints() {
        return filteredPoints;
    }

    public void setFilteredPoints(List<PointVo> filteredPoints) {
        this.filteredPoints = filteredPoints;
    }
    
}
