package org.example;

/**
 * THe ExceptionVectorLength is used to show that a vector is too short.
 */
public class ExceptionVectorLength extends Exception{
    /**
     * Constructor of the ExceptionVectorLength. If called, returns the message
     * "The lenght of the vector is shorter than 1.".
     */
    public ExceptionVectorLength() {
        super("The length of the vector is shorter than 1.");
    }
}
