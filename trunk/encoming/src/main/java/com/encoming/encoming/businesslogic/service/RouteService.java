/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.service;

import com.encoming.encoming.dao.DAOFactory;
import com.encoming.encoming.dao.PointDAO;
import com.encoming.encoming.entity.Route;
import com.encoming.encoming.dao.RouteDAO;
import com.encoming.encoming.dao.ShippingDAO;
import com.encoming.encoming.vo.RouteVo;
import com.encoming.encoming.vo.ShippingVo;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author FAMILIA
 */
public class RouteService implements IService<RouteVo> {

    private static RouteService instance;

    public static synchronized RouteService getInstance() {
        if (instance == null) {
            instance = new RouteService();
        }
        return instance;
    }

    @Override
    public void persist(RouteVo vo, EntityManager em) {
        System.out.println("entra a persistir en routeservice");
        Route entity = new Route();
        System.out.println("va a crear un pointdao");
        PointDAO pointDao = DAOFactory.getInstance().getPointDAO();
        System.out.println("lo crea");
        entity.setDestinationPoint(pointDao.find(vo.getDestinationPointId(), em));
        System.out.println("asigana el punto a la entidad ruta");
        entity.setOriginPoint(pointDao.find(vo.getOriginPointId(), em));
        System.out.println("asigana el punto2 a la entidad ruta");    
        entity.setNumberKilometers(vo.getNumberKilometers());
        System.out.println("v a persistr");
        DAOFactory.getInstance().getRouteDAO().persist(entity, em);
        System.out.println("persiste");
    }

    @Override
    public RouteVo find(Object id, EntityManager em) {
        RouteDAO dao = DAOFactory.getInstance().getRouteDAO();
        RouteVo routeVo = dao.find(id, em).toVo();
        return routeVo;
    }
    
     public Integer findIdRoute(Object originCity, Object destinationCity, EntityManager em) {
        RouteDAO dao = DAOFactory.getInstance().getRouteDAO();
        Integer a;
        try{
        a = dao.findIdRoute(originCity,destinationCity, em);
        }catch (NullPointerException e){
            return null;
        }
        return a;
    }
     
    public Integer findNewIdRoute(EntityManager em) {
        RouteDAO dao = DAOFactory.getInstance().getRouteDAO();
        Integer a = dao.findNewIdRoute(em);
        return a;
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

    public void updateKm(Integer idRoute, double numberKilometers, EntityManager em) {
        DAOFactory.getInstance().getRouteDAO().updateKm(idRoute, numberKilometers, em);
    }
}