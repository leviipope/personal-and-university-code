import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            System.out.println("Ez volt:" + s);
        }

        /*int szam = scanner.nextInt();
        System.out.println(szam + 5);*/
    }
}
