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
import java.util.Date;
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
}
