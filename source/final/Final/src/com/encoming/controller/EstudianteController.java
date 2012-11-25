/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.controller;

import com.encoming.businesslogic.facade.EstudianteFacade;
import com.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.utils.DataBaseException;
import com.encoming.utils.ExisteEstudianteException;
import com.encoming.vo.EstudianteVo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class EstudianteController {

    public void IngresarEstudiante(String nombres, String apellidos, Date fechaDeNacimiento, String documento) throws ExisteEstudianteException {

        EstudianteFacade estudianteFacade = FacadeFactory.getInstance().getEstudianteFacade();
        String nombreCompleto = nombres + " " + apellidos;

        if (FacadeFactory.getInstance().getEstudianteFacade().findByDocument(documento) == null) {
            EstudianteVo estudianteVo = new EstudianteVo();
            estudianteVo.setDocumento(documento);
            estudianteVo.setFechaNacimiento(fechaDeNacimiento);
            estudianteVo.setActivo(true);
            estudianteVo.setNombre(nombreCompleto);
            try {
                estudianteFacade.create(estudianteVo);
            } catch (DataBaseException ex) {
                Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            throw new ExisteEstudianteException("Ya existe el estudiante");
        }
    }
    
    public Object[] getEstudiantesIDNames(){
        List<String> nombres = new ArrayList<String>();
        List<EstudianteVo> estudiantes=FacadeFactory.getInstance().getEstudianteFacade().getList();
        if (estudiantes !=null){
            for(EstudianteVo estudianteVo:estudiantes){
                nombres.add(estudianteVo.getNombre());
            }
        }        
        return nombres.toArray();
    }
    
    public static String validateName(String name){
        int a = name.length();
        if(a < 3 || a > 15){
            return "¡La longitud del nombre debe estar entre 3 y 15!";
        }else if(name.contains("1") || 
                name.contains("2") || 
                name.contains("3") || 
                name.contains("4") || 
                name.contains("5") || 
                name.contains("6") || 
                name.contains("7") || 
                name.contains("8") || 
                name.contains("9") || 
                name.contains("0")) {
            return "¡El nombre no debe contener números!";
        }
        else if(name.contains("!") ||
                name.contains("#") ||
                name.contains("$") ||
                name.contains("&") ||
                name.contains("/") ||
                name.contains("(") ||
                name.contains(")") ||
                name.contains("@")) {
            return "¡El nombre no debe contener símbolos!";
        } else{
            return "Validado";
        }
    }
    public static String validateLastName(String name) {
        int a = name.length();
        if (a < 5 || a > 25) {
            return "¡La longitud del apellido debe estar entre 5 y 25!";
        } else if (name.contains("1")
                || name.contains("2")
                || name.contains("3")
                || name.contains("4")
                || name.contains("5")
                || name.contains("6")
                || name.contains("7")
                || name.contains("8")
                || name.contains("9")
                || name.contains("0")) {
            return "¡El apellido no debe contener números!";
        } else if (name.contains("!")
                || name.contains("#")
                || name.contains("$")
                || name.contains("&")
                || name.contains("/")
                || name.contains("(")
                || name.contains(")")
                || name.contains("@")) {
            return "¡El apellido no debe contener símbolos!";
        } else {
            return "Validado";
        }
    }
    
    public static String validateId(int id) {
        if (id<10000000 || id>999999999) {
            return "El documento debe ser un número entre 10000000 y 999999999";
        }
        return "Validado";
    }
    
    public static String validateDay(String str) {
        if (str.length() == 0) {
            return "Validado";
        }
        Integer id = Integer.parseInt(str);
        if (id < 1 || id > 31) {
            return "¡El dia debe estar en un rango valido!";
        }
        return "Validado";
    }

    public static String validateMonth(String str) {
        if (str.length() == 0) {
            return "Validado";
        }
        Integer id = Integer.parseInt(str);
        if (id < 1 || id > 12) {
            return "¡El mes debe estar en un rango valido,1-12!";
        }
        return "Validado";
    }

    public static String validateYear(String str) {
        if (str.length() == 0) {
            return "Validado";
        }
        Integer id = Integer.parseInt(str);
        if (id < 1960 || id > 2002) {
            return "¡El año tiene que estar entre 1960 y 2002!";
        }
        return "Validado";
    }
}
