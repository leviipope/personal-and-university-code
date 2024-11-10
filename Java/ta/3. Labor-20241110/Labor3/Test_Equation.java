/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Labor3;

/**
 *
 * @author student
 */
public class Test_Equation {

    public static void main(String[] args) {
        QuadrarticEquation e = new QuadrarticEquation(3, -7, -5);

        System.out.println(e);
        System.out.println("x1= " + e.getRoot1());
        System.out.println("x2=" + e.getRoot2());
    }

}
