/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.dao;

import com.encoming.encoming.entity.Administrator;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class AdministratorDAO implements IDAO<Administrator> {

    private static AdministratorDAO instance;
    
    public static synchronized AdministratorDAO getInstance() {
        if (instance == null) {
            instance = new AdministratorDAO();
        }
        return instance;
    }
    
    @Override
    public void persist(Administrator entity, EntityManager em) {
        em.persist(entity);
    }

    @Override
    public Administrator find(Object id, EntityManager em) {
        Query query = em.createQuery("SELECT adm FROM Administrator adm "
                + "WHERE adm.personidPerson.idPerson =:idPerson")
                .setParameter("idPerson", id);
        return (Administrator)query.getSingleResult();
    }

    @Override
    public void update(Administrator entity, EntityManager em) {
       em.merge(em);
    }

    @Override
    public void delete(Object id, EntityManager em) {
        Administrator admin = find(id, em);
        em.remove(admin);
    }

    @Override
    public List<Administrator> getList(EntityManager em) {
        Query query = em.createNamedQuery("Administrator.findAll");
        List<Administrator> lista = query.getResultList();
        return lista;
    }
    
    public Administrator login(Administrator entity, EntityManager em) {
        Administrator administrator;
        Query q = em.createQuery("SELECT u FROM Person u "
                + "WHERE u.idPerson LIKE :username "
                + "AND u.password LIKE :password")
                .setParameter("username", entity.getUsername())
                .setParameter("password", entity.getPassword());
        try {
            administrator = (Administrator) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            administrator = (Administrator) q.getResultList().get(0);
        } catch (NoResultException e) {
            administrator = null;
        }
        return administrator;
    }   
}
