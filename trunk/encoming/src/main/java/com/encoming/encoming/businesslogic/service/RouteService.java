/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.service;

import com.encoming.encoming.dao.DAOFactory;
import com.encoming.encoming.dao.RouteDAO;
import com.encoming.encoming.vo.RouteVo;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author FAMILIA
 */
public class RouteService implements IService<RouteVo>{
    
    private static RouteService instance;

    public static synchronized RouteService getInstance() {
        if (instance == null) {
            instance = new RouteService();
        }
        return instance;
    }

    @Override
    public void persist(RouteVo vo, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public RouteVo find(Object id, EntityManager em) {
        RouteDAO dao = DAOFactory.getInstance().getRouteDAO();
        RouteVo routeVo = dao.find(id, em).toVo();
        return routeVo;
    }

    @Override
    public void update(RouteVo vo, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<RouteVo> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
