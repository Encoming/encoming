/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.entity.Administrator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class tableBeanEmpleados {

    List <Administrator> employees;
    
    public tableBeanEmpleados() {
    }
    public void getEmployees(){
        
    }
}
