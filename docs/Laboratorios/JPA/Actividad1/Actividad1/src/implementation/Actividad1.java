/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import entity.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class Actividad1 {

    /*public void agregarCliente(Cliente cliente) {
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("Actividad1PU");
     EntityManager em = emf.createEntityManager();
     em.getTransaction().begin();
     try {
     em.merge(cliente);
     em.getTransaction().commit();
     } catch (Exception e) {
     System.out.println("El cliente No Puede Ser Agregado A La Base De Datos");
     e.printStackTrace();
     em.getTransaction().rollback();
     } finally {
     em.close();
     }
     }*/
    public void agregarCliente(Cliente cliente) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Actividad1PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("El Cliente No Puede Ser Agregado A La Base De Datos");
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    /*public void agregarCliente() {
     ClienteFacade facade = FacadeFactory.getInstance().getClienteFacade();
     ClienteVo vo = new ClienteVo();
     vo.setDocumento("3");
     vo.setEmail("1@c");
     vo.setId(3);
     vo.setNombreCompleto("Pedro");
     vo.setTelefono(3);

     facade.create(vo);
     System.out.println("success");
     }*/
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente cliente = new Cliente(2, "Pedro", "2", 2, "B");
        Actividad1 actividad1 = new Actividad1();
        actividad1.agregarCliente(cliente);

    }
}
