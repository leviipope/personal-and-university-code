import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = new double[2];

        for(int i = 0; i< numbers.length; i++){
            System.out.println("Kérek egy számot!: ");
            String s = scanner.nextLine();

            double number = Double.parseDouble(s);
            numbers[i] = number;
        }

        for(var number : numbers){
            System.out.println(number);
        }

    }
}