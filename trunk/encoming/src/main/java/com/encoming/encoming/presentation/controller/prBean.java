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
import javax.faces.model.SelectItem;

/**
 *
 * @author FAMILIA
 */
@ManagedBean
@RequestScoped
public class prBean {
    
    private List<SelectItem> points;
    
        public List<SelectItem> getPoints() {
        if (points == null) {
            points = new ArrayList<SelectItem>();
            List<PointVo> pointList = FacadeFactory.getInstance().getPointFacade().getList();
            if (pointList != null) {
                for (PointVo point : pointList) {
                    points.add(new SelectItem(point.getName()));
                }
            }
        }
        return points;
    }

    /**
     * Creates a new instance of prBean
     */
    public prBean() {
    }
}
