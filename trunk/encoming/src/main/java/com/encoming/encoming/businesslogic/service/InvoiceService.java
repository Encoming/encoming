/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.service;

import com.encoming.encoming.vo.InvoiceVo;
import com.encoming.encoming.entity.Invoice;
import com.encoming.encoming.dao.DAOFactory;
import com.encoming.encoming.dao.EncomingDAO;
import com.encoming.encoming.dao.ShippingDAO;
import com.encoming.encoming.dao.InvoiceDAO;
import com.encoming.encoming.entity.Encoming;
import com.encoming.encoming.entity.Shipping;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author FAMILIA
 */
public class InvoiceService implements IService<InvoiceVo>{
    
    private static InvoiceService instance;

    public static synchronized InvoiceService getInstance() {
        if (instance == null) {
            instance = new InvoiceService();
        }
        return instance;
    }

    @Override
    public void persist(InvoiceVo vo, EntityManager em) {
        Invoice entity = new Invoice();
        entity.setSender(vo.getSender());
        entity.setReceiver(vo.getReceiver());
        entity.setMoment(vo.getMoment());
        
        EncomingDAO encomingdao = DAOFactory.getInstance().getEncomingDAO();
        Encoming encoming = encomingdao.find(vo.getIdEncoming(), em);
        entity.setEncoming(encoming);
        
        ShippingDAO shippingdao = DAOFactory.getInstance().getShippingDAO();
        Shipping shipping = shippingdao.find(vo.getIdShipping(), em);
        entity.setShipping(shipping);
        
        DAOFactory.getInstance().getInvoiceDAO().persist(entity, em);
    }

    @Override
    public InvoiceVo find(Object id, EntityManager em) {
        InvoiceDAO dao = DAOFactory.getInstance().getInvoiceDAO();
        InvoiceVo invoicevo = dao.find(id, em).toVo();
        return invoicevo;
    }

    @Override
    public void update(InvoiceVo vo, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<InvoiceVo> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
