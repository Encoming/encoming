/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Cliente;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class ClienteDAO implements IDAO<Cliente> {

    private static ClienteDAO instance;

    public static synchronized ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

    @Override
    public void persist(Cliente entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Cliente find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Cliente entity, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Cliente> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
