/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class Actividad1 {

    public void agregarCliente(Cliente cliente) {
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
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente cliente=new Cliente(2, "Pedro", "2", 2, "B");
        Actividad1 actividad1=new Actividad1();
        actividad1.agregarCliente(cliente);
    }
}
