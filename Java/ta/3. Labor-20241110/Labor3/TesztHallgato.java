/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Labor3;

/**
 *
 * @author student
 */
public class TesztHallgato {
    
    public static void main(String[] args) {
        
        Hallgato h1 = new Hallgato("Kiss Panna", "QWE234", 2.6, 2);
        System.out.println(h1);
        System.out.println(h1.getNev());
        h1.setNev("Nagy Panna");
        System.out.println(h1.getNev());
        h1.koszon(2);
        
    }
    
}
