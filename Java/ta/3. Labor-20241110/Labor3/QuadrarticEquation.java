/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Labor3;

/**
 *
 * @author student
 */
public class QuadrarticEquation {

    private double a;
    private double b;
    private double c;

    public QuadrarticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
    
    public double getDiscriminant()
    {
    
     return this.b*this.b - 4* this.a * this.c;
    
    }
    
    public double getRoot1()
    {
        if (this.getDiscriminant() <0)
            return 0;
        else
            return  ( (-1)*this.b + Math.sqrt(this.getDiscriminant())) / (2*this.a);   
    
    }
    
     
     public double getRoot2()
    {
        if (this.getDiscriminant() <0)
            return 0;
        else
            return  ( (-1)*this.b - Math.sqrt(this.getDiscriminant())) / (2*this.a);   
    
    }

    @Override
    public String toString() {
        
        return this.a + "x^2" + this.b + "x" +this.c;
    }
    
     
     
    
}
