/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.utils;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class NoPrerrequisitosException extends Exception {

    /**
     * Creates a new instance of
     * <code>NoPrerrequisitosException</code> without detail message.
     */
    public NoPrerrequisitosException() {
    }

    /**
     * Constructs an instance of
     * <code>NoPrerrequisitosException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public NoPrerrequisitosException(String msg) {
        super(msg);
    }
}
