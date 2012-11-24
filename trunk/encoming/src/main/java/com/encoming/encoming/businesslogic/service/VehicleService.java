/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.service;

import com.encoming.encoming.dao.DAOFactory;
import com.encoming.encoming.dao.VehicleDAO;
import com.encoming.encoming.entity.Driver;
import com.encoming.encoming.entity.Point;
import com.encoming.encoming.entity.Shipping;
import com.encoming.encoming.entity.Vehicle;
import com.encoming.encoming.vo.ShippingVo;
import com.encoming.encoming.vo.VehicleVo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author FAMILIA
 */
public class VehicleService implements IService<VehicleVo> {

    private static VehicleService instance;

    public static synchronized VehicleService getInstance() {
        if (instance == null) {
            instance = new VehicleService();
        }
        return instance;
    }

    @Override
    public void persist(VehicleVo vo, EntityManager em) {
        System.out.println("entra en el servicio");
        Vehicle entity = new Vehicle();
        System.out.println("hace una entidad vehicle");
        entity.setCapacity(vo.getCapacity());
        System.out.println("va a poner un conductor");
        entity.setDriver(DAOFactory.getInstance().getDriverDAO().findById(vo.getIdDriver(), em));
        System.out.println("pone el conductor");
        entity.setManufacturer(vo.getManufacturer());
        entity.setModel(vo.getModel());
        entity.setPlateLetters(vo.getPlateLetters());
        entity.setPlateNumber(vo.getPlateNumbers());
        System.out.println("va a poner un punto");
        entity.setPoint(DAOFactory.getInstance().getPointDAO().find(vo.getIdPoint(), em));
        System.out.println("pone un punto");
        entity.setStatus(vo.getStatus());
        entity.setType(vo.getType());       
        System.out.println("llena la entidad bien");
        DAOFactory.getInstance().getVehicleDAO().persist(entity, em);
        System.out.println("lleva a persistir");
    }

    @Override
    public VehicleVo find(Object id, EntityManager em) {
        VehicleDAO dao = DAOFactory.getInstance().getVehicleDAO();
        VehicleVo vo = dao.find(id, em).toVo();
        return vo;

    }

    public Integer findFreeVehicle (Integer idPoint, EntityManager em) {
        VehicleDAO dao = DAOFactory.getInstance().getVehicleDAO();
        Integer a = dao.findFreeVehicle(idPoint, em);
        return a;
    }
    
    @Override
    public void update(VehicleVo vo, EntityManager em) {
        Vehicle entity = new Vehicle();
        entity.setIdVehicle(vo.getIdVehicle());
        Driver driver = DAOFactory.getInstance().getDriverDAO().find(vo.getIdDriver(), em);
        entity.setDriver(driver);
        entity.setCapacity(vo.getCapacity());
        entity.setPlateLetters(vo.getPlateLetters());
        entity.setPlateNumber(vo.getPlateNumbers());
        entity.setModel(vo.getModel());
        ArrayList<Shipping> shipList = new ArrayList();
        for(ShippingVo sVo : vo.getShippingList()){
            Shipping ship = DAOFactory.getInstance().getShippingDAO().find(sVo.getIdShipping(), em);
            shipList.add(ship);
        }
        entity.setShippingList(shipList);
        Point point = DAOFactory.getInstance().getPointDAO().find(vo.getIdPoint(), em);
        entity.setPoint(point);
        DAOFactory.getInstance().getVehicleDAO().update(entity, em);
    }

    @Override
    public void delete(Object id, EntityManager em) {
        VehicleDAO dao = DAOFactory.getInstance().getVehicleDAO();
        dao.delete(id, em);
    }

    @Override
    public List<VehicleVo> getList(EntityManager em) {
        VehicleDAO dao = DAOFactory.getInstance().getVehicleDAO();
        List<Vehicle> lista = dao.getList(em);
        ArrayList<VehicleVo> vehicles = new ArrayList();
        for (Vehicle p : lista) {
            vehicles.add(p.toVo());
        }
        return vehicles;
    }
    
    public VehicleVo findByPlate(EntityManager em ,Object plateNumbers 
                                ,Object plateLetters)
    {
        VehicleDAO dao = DAOFactory.getInstance().getVehicleDAO();
        VehicleVo vehVo = dao.findByPlate(em, plateNumbers, plateLetters);
        return vehVo;
    }
}
