package org.example;

/**
 * The Main class of the project
 */
public class Main {
    /**
     * The main method, makes the project runnable
     * @param args allows to use the command-line parameters in the program
     */
    public static void main(String[] args) {
        try {
            Vector v1 = new Vector(0.5,0);
            System.out.println(v1);
        } catch (ExceptionVectorLength e) {
            System.out.println(e.getMessage());
        }

        try {
            Vector v1 = new Vector(1,2);
            System.out.println(v1);
        } catch (ExceptionVectorLength e) {
            System.out.println(e.getMessage());
        }
    }
}