/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.facade;

import businesslogic.service.ServiceFactory;


/**
 *
 * @author juanmanuelmartinezromero
 */
public class FacadeFactory {

    private String PU = "ActividadPU";
    private static FacadeFactory instance;

    public static synchronized FacadeFactory getInstance() {
        if (instance == null) {
            instance = new FacadeFactory();
        }
        return instance;
    }

    public ClienteFacade getClienteFacade() {
        return new ClienteFacade(PU, ServiceFactory.getInstance().getClienteService());
    }
}