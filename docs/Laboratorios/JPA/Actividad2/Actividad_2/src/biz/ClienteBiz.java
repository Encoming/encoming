/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biz;

import dao.ClienteDAO;
import entity.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author andres
 */
public class ClienteBiz {
    
    EntityManagerFactory cli = Persistence.createEntityManagerFactory("Actividad_2PU");
    EntityManager cl = cli.createEntityManager();
    
    public void inscribirCliente(int id, String nombre, String documento, int telefono, String email ){
        ClienteDAO dao = new ClienteDAO(cl);
        cl.getTransaction().begin();
        Cliente cli = dao.crearCliente(id, nombre, documento, telefono, email);
        cl.getTransaction().commit();
        cl.close();
        System.out.println(cli);
    }
    
    public String listar(){
        String listado = "";
        ClienteDAO dao = new ClienteDAO(cl);
        cl.getTransaction().begin();
        List<Cliente> lista = dao.encontrarTodosClientes();
        int i =0;
        for (Cliente u : lista){
            i++;
            listado += "CLIENTE " + Integer.toString(i)
                    + "\nId: " + u.getId()
                    + "\nDocumento: " + u.getDocumento()
                    + "\nNombre: " + u.getNombreCompleto() + "\n\n";
            }     
        return listado;
    }
    public String buscar(int id){
        ClienteDAO dao = new ClienteDAO(cl);
        String resp="";
        cl.getTransaction().begin();
        Cliente cli = dao.encontrarCliente(id);
        cl.getTransaction().commit();
        resp += "Documento: " + cli.getDocumento()
             + "\nNombre: " + cli.getNombreCompleto()+ "\n\n";
        cl.close();
        return resp;
    }
    
    public void borrar(int id){
        ClienteDAO dao = new ClienteDAO(cl);
        cl.getTransaction().begin();
        dao.borrarCliente(id);
        cl.getTransaction().commit();
        cl.close();
    }
    
    public void actualizar(int id, String nombre){
        ClienteDAO dao = new ClienteDAO(cl);
        cl.getTransaction().begin();
        dao.cambiarNombreCliente(id, nombre);
        cl.getTransaction().commit();
        cl.close();
        
    }
}
