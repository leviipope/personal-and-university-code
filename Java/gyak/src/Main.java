import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 3 numbers separated by ';' ");

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] numbers = line.split(";");
            if(numbers.length < 3) {
                System.out.println("Invalid input, too few numbers");
                System.out.println("Enter the 3 numbers separated by ';' ");
                continue;
            }
            if(numbers.length > 3) {
                System.out.println("Invalid input, too many numbers, only first three will be used");
            }

            double a = Double.parseDouble(numbers[0]);
            double b = Double.parseDouble(numbers[1]);
            double c = Double.parseDouble(numbers[2]);

            if(a<=0 || b<=0 || c<=0) {
                System.out.println("Invalid input");
                System.out.println("Enter the 3 numbers separated by ';' ");
                continue;
            }

            if (a+b>c && a+c>b && b+c>a){
                System.out.println("The triangle is valid");
            }
            else{
                System.out.println("The triangle is not valid");
                System.out.println("Enter the 3 numbers separated by ';' ");
                continue;
            }

            if(a < b){
                double cs = a;
                a = b;
                b = cs;
            }
            if(a < c){
                double cs = a;
                a = c;
                c = cs;
            }

            if(a*a == b*b + c*c){
                System.out.println("Derékszögű");
            }
            else if (a*a < b*b + c*c){
                System.out.println("Hegyesszögű");
            }
            else{
                System.out.println("Tompaszögű");
            }

            System.out.print("Kérek 3 számot ; elválasztva: ");
        }
        sc.close();
    }
}