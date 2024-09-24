import java.util.Scanner;

public class ReadIn3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String v;
        System.out.println("Kérek egy sztringet: ");
        while (reader.hasNext()){
            v = reader.next();
            System.out.println("Ez volt :" + v);
            System.out.println("Kérek egy sztringet: ");
        }

        reader.close();
    }
}