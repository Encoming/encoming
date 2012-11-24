/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.utils;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class ExisteEstudianteException extends Exception {

    /**
     * Creates a new instance of
     * <code>ExisteEstudianteException</code> without detail message.
     */
    public ExisteEstudianteException() {
    }

    /**
     * Constructs an instance of
     * <code>ExisteEstudianteException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ExisteEstudianteException(String msg) {
        super(msg);
    }
}
