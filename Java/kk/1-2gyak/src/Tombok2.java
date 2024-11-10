import java.util.Scanner;

public class Tombok2 {
    public static void main(String[] args) {
        double[] szamTomb = new double[10];

        Scanner reader = new Scanner(System.in);

        for(int i=0; i <szamTomb.length; i++){
            System.out.print("Kérek egy számot: ");
            double s = reader.nextDouble();

            szamTomb[i] = s;
        }

        double sum = 0;
        double min =Double.MAX_VALUE;
        double max =Double.MIN_VALUE;

        java.util.Arrays.sort(szamTomb);
        for(double d: szamTomb){
            System.out.println("szam: " + d);
            if (min > d) min = d;
            if (max < d) max = d;
            sum += d; //sum = sum + d
        }

        System.out.println(szamTomb);
        System.out.println("min: " + min);
        System.out.println("max: " + max);
        System.out.println("osszeg: " + sum);
        System.out.println("atlag: " + sum/szamTomb.length);

        System.out.println(java.util.Arrays.toString(szamTomb));
        reader.close();
    }
}