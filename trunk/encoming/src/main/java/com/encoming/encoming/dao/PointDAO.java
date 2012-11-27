/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.dao;

import com.encoming.encoming.entity.Point;
import com.encoming.encoming.vo.PointVo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class PointDAO implements IDAO<Point> {

    private static PointDAO instance;

    public static synchronized PointDAO getInstance() {
        if (instance == null) {
            instance = new PointDAO();
        }
        return instance;
    }

    @Override
    public void persist(Point entity, EntityManager em) {
        em.persist(entity);
    }

    @Override
    public Point find(Object id, EntityManager em) {
        Query query = em.createQuery("SELECT p FROM Point p WHERE p.idPoint=:idPoint").setParameter("idPoint", id);
        return (Point)query.getSingleResult();
    }
    
    public Integer finIdPoint(String originCity, EntityManager em) {
        javax.persistence.Query query = em.createQuery("SELECT p.idPoint FROM Point p"
                + " WHERE p.name=:originCity")
                .setParameter("originCity", originCity);
        return (Integer)query.getSingleResult();
    }

    @Override
    public void update(Point entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Point> getList(EntityManager em) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Point.class));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }
    public PointVo findByName(EntityManager em, Object name){
        Query q = em.createNamedQuery("Point.findByName").setParameter("name", name);
        Point point = (Point)q.getSingleResult();
        PointVo pVo= point.toVo();
        return pVo;
    }

    public String findNamePoint(Integer idPoint, EntityManager em) {
        javax.persistence.Query query = em.createQuery("SELECT p.name FROM Point p"
                + " WHERE p.idPoint=:idPoint")
                .setParameter("idPoint", idPoint);
        return (String)query.getSingleResult();
    }
}
