package com.encoming.businesslogic.facade;

import com.encoming.businesslogic.service.IService;
import com.encoming.utils.DataBaseException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Alexander
 */
public class Facade<VO> {

    protected EntityManagerFactory emf;
    protected EntityManager em;
    protected IService service;

    public Facade(String PUName, IService service) {
        emf = Persistence.createEntityManagerFactory(PUName);
        em = emf.createEntityManager();
        this.service = service;
    }

    public void create(VO vo) throws DataBaseException {
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            service.create(vo, em);
            tx.commit();
        } catch (Exception e) {
            if (em != null && tx != null) {
                tx.rollback();
            }
            throw new DataBaseException("Ha ocurrido un error al persistir");
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }

    public void create1(VO vo) {
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            service.create(vo, em);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em != null && tx != null) {
                tx.rollback();
            }
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }

    public VO find(Object id) {
        try {
            return (VO) service.find(id, em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }

    }

    public boolean update(VO vo) {
        EntityTransaction tx = null;
        boolean ret = false;
        try {
            tx = em.getTransaction();
            tx.begin();
            service.update(vo, em);
            tx.commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (em != null && tx != null) {
                tx.rollback();
            }
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
            return ret;
        }
    }

    public boolean delete(Object id) {
        EntityTransaction tx = null;
        boolean ret = false;
        try {
            tx = em.getTransaction();
            tx.begin();
            service.delete(id, em);
            tx.commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (em != null && tx != null) {
                tx.rollback();
            }
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
            return ret;
        }
    }

    public List<VO> getList() {
        try {
            return service.getList(em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }
}
