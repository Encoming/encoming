/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Familia Martinez
 */
public class Actividad1 {

    public void agregarCliente(Cliente cliente) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Actividad_1.7PU");
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente cliente = new Cliente(258012, "Juan", "1018451342", 5290587, "jmmartinezro@gmail.com");
        Actividad1 actividad1 = new Actividad1();
        actividad1.agregarCliente(cliente);
    }
}
