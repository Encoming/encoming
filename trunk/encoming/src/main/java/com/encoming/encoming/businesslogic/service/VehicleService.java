/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.service;

import com.encoming.encoming.dao.DAOFactory;
import com.encoming.encoming.dao.DriverDAO;
import com.encoming.encoming.dao.VehicleDAO;
import com.encoming.encoming.entity.Driver;
import com.encoming.encoming.entity.Vehicle;
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
        DriverDAO driverDao = DAOFactory.getInstance().getDriverDAO();

        Driver driver = driverDao.find(vo.getIdDriver(), em);
        Vehicle entity = new Vehicle();


        entity.setIdVehicle(vo.getIdVehicle());
        entity.setDriver(driver);
        entity.setCapacity(vo.getCapacity());
        entity.setDestinationCity(vo.getDestinationCity());
        entity.setPlateLetters(vo.getPlateLetters());
        entity.setPlateNumber(vo.getPlateNumber());
        entity.setModel(vo.getModel());

        DAOFactory.getInstance().getVehicleDAO().persist(entity, em);
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
        entity.setDestinationCity(vo.getDestinationCity());
        entity.setPlateNumber(vo.getPlateNumber());
        entity.setModel(vo.getModel());
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
}
