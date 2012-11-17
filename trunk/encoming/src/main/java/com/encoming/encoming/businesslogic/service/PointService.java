/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.businesslogic.service;

import com.encoming.encoming.dao.DAOFactory;
import com.encoming.encoming.dao.PointDAO;
import com.encoming.encoming.entity.Point;
import com.encoming.encoming.vo.PointVo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class PointService implements IService<PointVo> {

    private static PointService instance;

    public static synchronized PointService getInstance() {
        if (instance == null) {
            instance = new PointService();
        }
        return instance;
    }

    @Override
    public void persist(PointVo vo, EntityManager em) {
        Point entity = new Point();
        entity.setName(vo.getName());
        entity.setLatitude(vo.getLatitude());
        entity.setLongitude(vo.getLongitude());

        DAOFactory.getInstance().getPointDAO().persist(entity, em);
    }

    @Override
    public PointVo find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Integer findIdPoint(String originCity, EntityManager em) {
        PointDAO dao = DAOFactory.getInstance().getPointDAO();
        Integer a= dao.finIdPoint(originCity, em);
        return a;
    }

    @Override
    public void update(PointVo vo, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<PointVo> getList(EntityManager em) {
        List<PointVo> list = new ArrayList<PointVo>();
        for (Point point : DAOFactory.getInstance().getPointDAO().getList(em)) {
            list.add((point).toVo());
        }
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                PointVo p1 = (PointVo) o1;
                PointVo p2 = (PointVo) o2;
                return p1.getName().compareTo(p2.getName());
            }
        });
        return list;
    }
}
