package exceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // exception = an event that occurs during the execution of a program that,
        //             disrupts the normal flow of instructions

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("num to divide: ");
            int num = sc.nextInt();

            System.out.println("num to divide by: ");
            int num2 = sc.nextInt();

            double res = (double) num / num2;
            System.out.println(res);
        }
        catch (ArithmeticException e) {
            System.out.println("You cant divide by zero idiot");
        }
        catch (InputMismatchException e) {
            System.out.println("ENTER A NUMBER OMFG");
        }
        catch (Exception e) { // every excpetion
            System.out.println("BRUUUUUUUUUUUUUUUUUUUUUUUUUUUUUH");
        }
        finally { //it will execute wether or not we catch an exception, a good use is to close any scanners
            System.out.println("This will execute anyway");
            sc.close();
        }
    }


}
