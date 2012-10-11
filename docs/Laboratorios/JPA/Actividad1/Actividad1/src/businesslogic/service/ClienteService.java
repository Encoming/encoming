/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.service;

import java.util.List;
import javax.persistence.EntityManager;
import vo.ClienteVo;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class ClienteService implements IService<ClienteVo> {

    private static ClienteService instance;

    public static synchronized ClienteService getInstance() {
        if (instance == null) {
            instance = new ClienteService();
        }
        return instance;
    }

    @Override
    public void persist(ClienteVo vo, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ClienteVo find(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(ClienteVo vo, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ClienteVo> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
