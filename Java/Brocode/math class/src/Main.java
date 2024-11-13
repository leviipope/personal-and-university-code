import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        double x = 3.14;
        double y = -10;

        Math.max(x, y); = 3.14
        Math.min(x, y); = -10
        Math.abs(y); = 10
        Math.sqrt(x); = 1.77
        Math.round(x) = 3.0
        Math.ceil(x) = 4.0
        Math.floor(x) = 3.0
        */

        // Hypotenuse = átfogó

        double x;
        double y;
        double z;

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter X: ");
        x = scan.nextDouble();
        System.out.println("Enter Y: ");
        y = scan.nextDouble();

        z = Math.sqrt((x*x)+(y*y));
        System.out.println("Hypotenuse is: "+z);

        scan.close();
    }
}