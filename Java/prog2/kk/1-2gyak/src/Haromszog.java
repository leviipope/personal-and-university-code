import java.util.Scanner;

public class Haromszog {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Kérek 3 számot ; elválasztva: ");
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            String[] szamok = s.split(";");
            if(szamok.length < 3){
                System.out.println("túl kevés szám");
                System.out.print("Kérek 3 számot ; elválasztva: ");
                continue;
            }
            if(szamok.length > 3){
                System.out.println("több a szám, mint 3 --> csak az első 3 lesz használva");
            }

            double a = Double.parseDouble(szamok[0]);
            double b = Double.parseDouble(szamok[1]);
            double c = Double.parseDouble(szamok[2]);

            if(a<=0 || b<=0 || c<=0){
                System.out.println("nem jók az oldalak");
                System.out.print("Kérek 3 számot ; elválasztva: ");
                continue;
            }

            if(a+b>c && a+c >b && c+b > a){
                System.out.println("a háromszög szerkeszthető");
            }
            else{
                System.out.println("a háromszög nem szerkeszthető");
                System.out.print("Kérek 3 számot ; elválasztva: ");
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