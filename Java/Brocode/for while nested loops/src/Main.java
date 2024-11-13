import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //while
        Scanner sc = new Scanner(System.in);
        String s = "";

        while(s.isBlank()){
            System.out.print("Enter a string: ");
            s = sc.nextLine();
        }

        System.out.println(s);

        //for
        for(int i = 10; i>= 0; i--){
            System.out.println(i);
        }
        System.out.println("Happy new year");

        //nested loops
        Scanner sc1 = new Scanner(System.in);
        int rows;
        int cols;
        String symbol = "";

        System.out.println("Enter the number of rows: ");
        rows = sc1.nextInt();
        System.out.println("Enter the number of columns: ");
        cols = sc1.nextInt();
        System.out.println("Enter the symbol: ");
        symbol = sc1.next();

        for(int i = 1; i <= rows; i++){
            System.out.println();
            for(int j = 1; j <= cols; j++){
                System.out.print(symbol);
            }
        }
    }
}