import java.util.Arrays;
import java.util.Scanner;
/*
* Összeg
* Átlag
* min, max
* rendezzük
* toString
* */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = new double[3];

        for(int i = 0; i< numbers.length; i++){
            System.out.println("Kérek egy számot!: ");
            String s = scanner.nextLine();

            double number = Double.parseDouble(s);
            numbers[i] = number;
        }

        //Összeg
        double sum = 0;
        for(var num : numbers){
            sum += num;
        }

        //Min-max
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        System.out.println("Max: "+ Double.MAX_VALUE + " min: " + Double.MIN_VALUE);

        for(var num : numbers){
            if(num > max){
                max = num;
            } else if (num < min) {
                min = num;
            }
        }

        Arrays.sort(numbers);

        for(var number : numbers){
            System.out.println(number);
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println(numbers.toString());
        System.out.println("min: " + min);
        System.out.println("max: " + max);
        System.out.println("összeg: " + sum);
        System.out.println("átlag: " + sum/numbers.length);

    }
}