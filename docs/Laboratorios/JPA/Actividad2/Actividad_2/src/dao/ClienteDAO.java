/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author andres
 */
public class ClienteDAO {
    protected EntityManager cl;
    
    public ClienteDAO(EntityManager cl){
        this.cl = cl;
    }
    
    public Cliente crearCliente(int id, String nombreCompleto, String documento, int telefono, String email){
        Cliente cli = new Cliente(id);
        cli.setNombreCompleto(nombreCompleto);
        cli.setDocumento(documento);
        cli.setTelefono(telefono);
        cli.setEmail(email);
        cl.persist(cli);
        return cli;
    }
    
    public void borrarCliente(int id){
        Cliente cli = encontrarCliente(id);
        if(cli != null){
            cl.remove(cli);
        }
    }
    
    public Cliente encontrarCliente(int id){
        return cl.find(Cliente.class, id);
    }
    
    public Cliente cambiarNombreCliente(int id, String nombreCompleto){
        Cliente cli = cl.find(Cliente.class, id);
        if(cli != null){
            cli.setNombreCompleto(nombreCompleto);
        }
        return cli;
    }
    
    public List<Cliente> encontrarTodosClientes(){
        TypedQuery<Cliente> query = cl.createQuery(
                "SELECT e FROM Cliente e", Cliente.class);
        return query.getResultList();
    }
}
