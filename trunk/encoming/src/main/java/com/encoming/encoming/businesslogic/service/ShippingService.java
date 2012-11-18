/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.service;

import com.encoming.encoming.dao.DAOFactory;
import com.encoming.encoming.dao.EncomingDAO;
import com.encoming.encoming.dao.InvoiceDAO;
import com.encoming.encoming.dao.PersonDAO;
import com.encoming.encoming.dao.RouteDAO;
import com.encoming.encoming.dao.ShippingDAO;
import com.encoming.encoming.dao.VehicleDAO;
import com.encoming.encoming.entity.Encoming;
import com.encoming.encoming.entity.Invoice;
import com.encoming.encoming.entity.Person;
import com.encoming.encoming.entity.Route;
import com.encoming.encoming.entity.Shipping;
import com.encoming.encoming.entity.Vehicle;
import com.encoming.encoming.vo.ShippingVo;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author FAMILIA
 */
public class ShippingService implements IService<ShippingVo> {

    private static ShippingService instance;

    public static synchronized ShippingService getInstance() {
        if (instance == null) {
            instance = new ShippingService();
        }
        return instance;
    }

    @Override
    public void persist(ShippingVo vo, EntityManager em) {
        Shipping entity = new Shipping();
        //entity.setIdShipping(vo.getIdShipping());
        entity.setIdReceiver(vo.getIdReceiver());
        entity.setArrivedDate(vo.getArrivedDate());
        entity.setSendedDate(vo.getSendedDate());
        entity.setCost(vo.getCost());
        
//        InvoiceDAO invoiceDAO = DAOFactory.getInstance().getInvoiceDAO();
//        Invoice invoice = invoiceDAO.find(vo.getIdInvoice(), em);
//        entity.setInvoice(invoice);
        
        PersonDAO persondao = DAOFactory.getInstance().getPersonDAO();
        Person person = persondao.find(vo.getIdPerson(), em);
        entity.setPerson(person);

        VehicleDAO vehicledao = DAOFactory.getInstance().getVehicleDAO();
        Vehicle vehicle = vehicledao.find(vo.getIdVehicle(), em);
        entity.setVehicle(vehicle);

        RouteDAO routedao = DAOFactory.getInstance().getRouteDAO();
        Route route = routedao.find(vo.getIdRoute(), em);
        entity.setRoute(route);

        EncomingDAO encomingdao = DAOFactory.getInstance().getEncomingDAO();
        Encoming encoming = encomingdao.find(vo.getIdEncoming(), em);
        entity.setEncoming(encoming);

        DAOFactory.getInstance().getShippingDAO().persist(entity, em);

    }

    @Override
    public ShippingVo find(Object id, EntityManager em) {
        ShippingDAO dao = DAOFactory.getInstance().getShippingDAO();
        ShippingVo shippingvo = dao.find(id, em).toVo();
        return shippingvo;
    }
    
    public Integer findMaxIdShipping(EntityManager em) {
        ShippingDAO dao = DAOFactory.getInstance().getShippingDAO();
        Integer a= dao.finMaxIdShipping(em);
        return a;
    }

    @Override
    public void update(ShippingVo vo, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ShippingVo> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
