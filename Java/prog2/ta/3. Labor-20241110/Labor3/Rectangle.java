/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Labor3;

/**
 *
 * @author student
 */
public class Rectangle {
    
    private double width;
    public double height;

    public Rectangle() {
        this.width= 1;
        this.height=1;        
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    public double getArea()
    {
       return this.width * this.height;
    
    }
    
    public double getPerimeter()
    {
    
       return 2 * (this.height + this.width);
    }
    
    
}
