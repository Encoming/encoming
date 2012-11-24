/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.utils;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class NoActivoException extends Exception {

    /**
     * Creates a new instance of
     * <code>NoActivoException</code> without detail message.
     */
    public NoActivoException() {
    }

    /**
     * Constructs an instance of
     * <code>NoActivoException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public NoActivoException(String msg) {
        super(msg);
    }
}
