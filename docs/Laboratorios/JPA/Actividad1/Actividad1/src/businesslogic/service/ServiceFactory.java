/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.service;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class ServiceFactory {

    private static ServiceFactory instance;

    public static synchronized ServiceFactory getInstance() {
        if (instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }

    public ClienteService getClienteService() {
        return ClienteService.getInstance();
    }
}
