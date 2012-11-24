/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.utils;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class DataBaseException extends Exception {

    /**
     * Creates a new instance of
     * <code>DataBaseException</code> without detail message.
     */
    public DataBaseException() {
    }

    /**
     * Constructs an instance of
     * <code>DataBaseException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public DataBaseException(String msg) {
        super(msg);
    }
}
