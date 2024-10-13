import java.util.Scanner;

public class Tombok {
    public static void main(String[] args) {
        double[] szamTomb = new double[10];

        Scanner reader = new Scanner(System.in);

        for(int i=0; i <szamTomb.length; i++){
            System.out.print("Kérek egy számot: ");
            double s = reader.nextDouble();

            szamTomb[i] = s;
        }

        for(double d: szamTomb){
            System.out.println(d);
        }

        System.out.println(szamTomb);
        reader.close();
    }
}