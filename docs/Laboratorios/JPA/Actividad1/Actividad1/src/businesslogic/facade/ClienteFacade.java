/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.facade;

import businesslogic.service.ClienteService;
import vo.ClienteVo;


/**
 *
 * @author juanmanuelmartinezromero
 */
public class ClienteFacade extends Facade<ClienteVo> {

    public ClienteFacade(String PUName, ClienteService service) {
        super(PUName, service);
    }
}
