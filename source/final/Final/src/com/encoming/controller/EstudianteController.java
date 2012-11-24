/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.controller;

import com.encoming.businesslogic.facade.EstudianteFacade;
import com.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.utils.ExisteEstudianteException;
import com.encoming.vo.EstudianteVo;
import java.util.Date;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class EstudianteController {

    public void IngresarEstudiante(String nombres, String apellidos, Date fechaDeNacimiento, String documento) throws ExisteEstudianteException {
        
        EstudianteFacade estudianteFacade = FacadeFactory.getInstance().getEstudianteFacade();
        String nombreCompleto = nombres + " " + apellidos;

        if(estudianteFacade.findByDocument(documento) != null){
            
        }


        EstudianteVo estudianteVo = new EstudianteVo();
        estudianteVo.setDocumento(documento);
        estudianteVo.setFechaNacimiento(fechaDeNacimiento);
        estudianteVo.setActivo(true);
        estudianteVo.setNombre(nombreCompleto);

        estudianteFacade.create(estudianteVo);
    }
}
